@file:JvmName("EmojiConverter")

package com.github.siosio

object EmojiConverter {

    @JvmStatic
    fun convert(value: String): String {
        if (value.contains(':').not()) {
            return value
        }

        val converterMap = mapOf(
                ":tada:" to "\uD83C\uDF89",
                ":bookmark:" to "\uD83D\uDD16",
                ":sparkles:" to "✨",
                ":bug:" to "\uD83D\uDC1B",
                ":card_index:" to "\uD83D\uDCC7",
                ":books:" to "\uD83D\uDCDA",
                ":bulb:" to "\uD83D\uDCA1",
                ":racehorse:" to "\uD83D\uDC0E",
                ":lipstick:" to "\uD83D\uDC84",
                ":rotating_light:" to "\uD83D\uDEA8",
                ":white_check_mark:" to "✅",
                ":heavy_check_mark:" to "✔️",
                ":zap:" to "⚡",
                ":art:" to "\uD83C\uDFA8",
                ":hammer:" to "\uD83D\uDD28",
                ":fire:" to "\uD83D\uDD25",
                ":green_heart:" to "\uD83D\uDC9A",
                ":lock:" to "\uD83D\uDD12",
                ":arrow_up:" to "⬆",
                ":arrow_down:" to "⬇",
                ":shirt:" to "\uD83D\uDC55",
                ":alien:" to "\uD83D\uDC7D",
                ":pencil:" to "✏",
                ":ambulance:" to "\uD83D\uDE91",
                ":rocket:" to "\uD83D\uDE80",
                ":apple:" to "\uD83C\uDF4E",
                ":penguin:" to "\uD83D\uDC27",
                ":checkered_flag:" to "\uD83C\uDFC1",
                ":construction:" to "\uD83D\uDEA7",
                ":wip:" to "\uD83D\uDEA7",
                ":construction_worker:" to "\uD83D\uDC77",
                ":chart_with_upwards_trend:" to "\uD83D\uDCC8",
                ":heavy_minus_sign:" to "➖",
                ":heavy_plus_sign:" to "➕",
                ":whale:" to "\uD83D\uDC0B",
                ":wrench:" to "\uD83D\uDD27",
                ":package:" to "\uD83D\uDCE6",
                ":twisted_rightwards_arrows:" to "\uD83D\uDD00",
                ":hankey:" to "\uD83D\uDCA9",
                ":rewind:" to "⏪",
                ":boom:" to "\uD83D\uDCA5",
                ":ok_hand:" to "\uD83D\uDC4C",
                ":wheelchair:" to "♿",
                ":truck:" to "\uD83D\uDE9A",
                ":recycle:" to "♻",
                ":wastebasket:" to "\uD83D\uDDD1",
                ":+1" to "\uD83D\uDC4D",
                "-1" to "\uD83D\uDC4E",
                ":100: " to "\uD83D\uDCAF",
                ":boom:" to "\uD83D\uDCA5",
                ":collision:" to "💥",
                ":anger:" to "\uD83D\uDCA2",
                ":blush" to "\uD83D\uDE0A",
                ":smiley:" to "\uD83D\uDE03",
                ":relaxed:" to "☺",
                ":smirk:" to "\uD83D\uDE0F",
                ":heart_eyes:" to "😍",
                ":kissing_heart:" to "😘"
                )

        return converterMap.entries
                .fold(value) { acc, entry ->
                    if (acc.contains(':').not()) {
                        return acc
                    }
                    acc.replace(entry.key, entry.value)
                }
    }
}
