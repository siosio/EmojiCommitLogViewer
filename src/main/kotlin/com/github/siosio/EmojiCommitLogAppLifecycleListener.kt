package com.github.siosio

import com.intellij.ide.AppLifecycleListener
import com.intellij.openapi.diagnostic.logger
import javassist.ClassClassPath
import javassist.ClassPool

class EmojiCommitLogAppLifecycleListener : AppLifecycleListener {

    override fun appFrameCreated(commandLineArgs: MutableList<String>) {
        val classPool = ClassPool.getDefault()
        classPool.insertClassPath(ClassClassPath(EmojiConverter::class.java))
        classPool.insertClassPath(ClassClassPath(EmojiMap::class.java))
        val gitLogClass = classPool["com.intellij.vcs.log.ui.render.GraphCommitCellRenderer"].nestedClasses.find { it.simpleName == "GraphCommitCellRenderer\$MyComponent" } ?: return
        gitLogClass.defrost()

        val classloader = Thread.currentThread().contextClassLoader
        val emojiMap = classPool["com.github.siosio.EmojiMap"]
        emojiMap.toClass(classloader, emojiMap.javaClass.protectionDomain)
        val emojiConverter = classPool["com.github.siosio.EmojiConverter"]
        emojiConverter.toClass(classloader, emojiConverter.javaClass.protectionDomain)

        val appendMethod = gitLogClass.getDeclaredMethod("appendText")
        appendMethod.insertBefore("""
            $1 = new com.intellij.vcs.log.ui.render.GraphCommitCell(com.github.siosio.EmojiConverter.convert($1.getText()), $1.getRefsToThisCommit(), $1.getPrintElements());""".trimIndent())

        try {
            gitLogClass.toClass()
            gitLogClass.writeFile()
        } catch (e: Exception) {
            logger<EmojiCommitLogAppLifecycleListener>().debug("unexpected exception", e)
        }
    }
}