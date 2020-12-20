import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

fun main() {

    File("input.json").inputStream().use {
        val mojis: List<Map<String, String>> = jacksonObjectMapper().readValue(it)
        mojis.forEach {
            println(""""${it["code"]}" to "${it["emoji"]}",""")
        }
    }
}