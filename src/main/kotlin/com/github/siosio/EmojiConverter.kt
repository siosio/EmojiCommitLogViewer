@file:JvmName("EmojiConverter")

package com.github.siosio

object EmojiConverter {

    @JvmStatic
    fun convert(value: String): String {
        if (value.contains(':').not()) {
            return value
        }

        val converterMap = mapOf(
            ":card_index:" to "\uD83D\uDCC7",
            ":books:" to "\uD83D\uDCDA",
            ":racehorse:" to "\uD83D\uDC0E",
            ":heavy_check_mark:" to "✔️",
            ":shirt:" to "\uD83D\uDC55",
            ":pencil:" to "✏",
            ":apple:" to "\uD83C\uDF4E",
            ":penguin:" to "\uD83D\uDC27",
            ":checkered_flag:" to "\uD83C\uDFC1",
            ":wip:" to "\uD83D\uDEA7",
            ":whale:" to "\uD83D\uDC0B",
            ":hankey:" to "\uD83D\uDCA9",
            ":ok_hand:" to "\uD83D\uDC4C",
            ":+1" to "\uD83D\uDC4D",
            ":-1:" to "\uD83D\uDC4E",
            ":100: " to "\uD83D\uDCAF",
            ":collision:" to "💥",
            ":anger:" to "\uD83D\uDCA2",
            ":blush" to "\uD83D\uDE0A",
            ":smiley:" to "\uD83D\uDE03",
            ":relaxed:" to "☺",
            ":smirk:" to "\uD83D\uDE0F",
            ":heart_eyes:" to "😍",
            ":kissing_heart:" to "😘",
            ":art:" to "🎨",
            ":zap:" to "⚡️",
            ":fire:" to "🔥",
            ":bug:" to "🐛",
            ":ambulance:" to "🚑",
            ":sparkles:" to "✨",
            ":memo:" to "📝",
            ":rocket:" to "🚀",
            ":lipstick:" to "💄",
            ":tada:" to "🎉",
            ":white_check_mark:" to "✅",
            ":lock:" to "🔒",
            ":bookmark:" to "🔖",
            ":rotating_light:" to "🚨",
            ":construction:" to "🚧",
            ":green_heart:" to "💚",
            ":arrow_down:" to "⬇️",
            ":arrow_up:" to "⬆️",
            ":pushpin:" to "📌",
            ":construction_worker:" to "👷",
            ":chart_with_upwards_trend:" to "📈",
            ":recycle:" to "♻️",
            ":heavy_plus_sign:" to "➕",
            ":heavy_minus_sign:" to "➖",
            ":wrench:" to "🔧",
            ":hammer:" to "🔨",
            ":globe_with_meridians:" to "🌐",
            ":pencil2:" to "✏️",
            ":poop:" to "💩",
            ":rewind:" to "⏪",
            ":twisted_rightwards_arrows:" to "🔀",
            ":package:" to "📦",
            ":alien:" to "👽",
            ":truck:" to "🚚",
            ":page_facing_up:" to "📄",
            ":boom:" to "💥",
            ":bento:" to "🍱",
            ":wheelchair:" to "♿️",
            ":bulb:" to "💡",
            ":beers:" to "🍻",
            ":speech_balloon:" to "💬",
            ":card_file_box:" to "🗃",
            ":loud_sound:" to "🔊",
            ":mute:" to "🔇",
            ":busts_in_silhouette:" to "👥",
            ":children_crossing:" to "🚸",
            ":building_construction:" to "🏗",
            ":iphone:" to "📱",
            ":clown_face:" to "🤡",
            ":egg:" to "🥚",
            ":see_no_evil:" to "🙈",
            ":camera_flash:" to "📸",
            ":alembic:" to "⚗",
            ":mag:" to "🔍",
            ":label:" to "🏷️",
            ":seedling:" to "🌱",
            ":triangular_flag_on_post:" to "🚩",
            ":goal_net:" to "🥅",
            ":dizzy:" to "💫",
            ":wastebasket:" to "🗑",
            ":passport_control:" to "🛂",
            ":adhesive_bandage:" to "🩹",
            ":monocle_face:" to "🧐"
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
