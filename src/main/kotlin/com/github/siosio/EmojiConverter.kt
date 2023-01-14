@file:JvmName("EmojiConverter")
package com.github.siosio

object EmojiConverter {

    @JvmStatic
    fun convert(value: String): String {
        if (value.contains(':').not()) {
            return value
        }
        return EmojiMap.gitmojis.entries
            .fold(value) { acc, entry ->
                if (acc.contains(':') .not()) {
                    return acc
                }
                acc.replace(entry.key, entry.value)
            }
    }
}
