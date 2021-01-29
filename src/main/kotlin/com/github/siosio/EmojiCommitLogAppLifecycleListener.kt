package com.github.siosio

import com.intellij.ide.AppLifecycleListener
import com.intellij.openapi.diagnostic.logger
import javassist.ClassClassPath
import javassist.ClassPool
import javassist.CtNewMethod
import java.io.IOException

class EmojiCommitLogAppLifecycleListener : AppLifecycleListener {

    override fun appFrameCreated(commandLineArgs: MutableList<String>) {
        val classPool = ClassPool.getDefault()
        classPool.appendClassPath(ClassClassPath(EmojiConverter::class.java))
        val ctClass = classPool["com.intellij.vcs.log.ui.render.GraphCommitCellRenderer"].nestedClasses.find { it.simpleName == "GraphCommitCellRenderer\$MyComponent" } ?: return
        ctClass.defrost()

        val m = ctClass.getDeclaredMethod("appendText")
        val converter = classPool["com.github.siosio.EmojiConverter"].getDeclaredMethod("convert")

        ctClass.addMethod(CtNewMethod.copy(converter, ctClass, null));
        m.insertBefore("""
            $1 = new com.intellij.vcs.log.ui.render.GraphCommitCell(convert($1.getText()), $1.getRefsToThisCommit(), $1.getPrintElements());""".trimIndent())


        try {
            ctClass.toClass()
            ctClass.writeFile()
        } catch (e: IOException) {
            logger<EmojiCommitLogAppLifecycleListener>().error("unexpected exception", e)
        }
    }
}