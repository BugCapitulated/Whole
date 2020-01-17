package bug.capitulated.core_common.theme

import androidx.appcompat.app.AppCompatDelegate
import bug.capitulated.core_common.util.isOreoOrMore

enum class Theme {

    LIGHT,
    DARK,
    SYSTEM,
    BATTERY;

    fun toInt() = when (this) {
        LIGHT -> 0
        DARK -> 1
        SYSTEM -> 2
        BATTERY -> 3
    }

    @AppCompatDelegate.NightMode
    fun toNightMode() = when (this) {
        LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
        DARK -> AppCompatDelegate.MODE_NIGHT_YES
        SYSTEM -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        BATTERY -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }

    companion object {

        val defaultTheme: Theme
            get() = if (isOreoOrMore()) SYSTEM else BATTERY

        val defaultThemeInt: Int get() = defaultTheme.toInt()

        fun getTheme(value: Int) = when (value) {
            0 -> LIGHT
            1 -> DARK
            2 -> SYSTEM
            3 -> BATTERY
            else -> throw IllegalArgumentException()
        }

    }

}