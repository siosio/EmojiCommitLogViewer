@file:JvmName("EmojiMap")
package com.github.siosio

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.URL

object EmojiMap {

    private val objectMapper = jacksonObjectMapper()

    @JvmStatic
    val gitmojis = get()["gitmojis"]?.associate { it["code"]!! to it["emoji"]!! } ?: emptyMap()

    @JvmStatic
    private fun get(): Map<String, List<Map<String, String>>> {

        return try {
            objectMapper.readValue(
                URL("https://raw.githubusercontent.com/carloscuesta/gitmoji/master/packages/gitmojis/src/gitmojis.json"),
                Map::class.java
            ) as Map<String, List<Map<String, String>>>
        } catch (e: Exception) {
            emptyMap<String, List<Map<String, String>>>()
        }
    }
}