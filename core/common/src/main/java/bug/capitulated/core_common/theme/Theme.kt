package bug.capitulated.core_common.theme

import androidx.appcompat.app.AppCompatDelegate
import bug.capitulated.core_common.util.is26orMore

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
        SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        BATTERY -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
    }
    
    companion object {
        
        val defaultTheme: Theme
            get() = LIGHT
        
        val defaultThemeInt: Int get() = defaultTheme.toInt()
        
        fun themeOfInt(value: Int) = when (value) {
            0 -> LIGHT
            1 -> DARK
            2 -> SYSTEM
            3 -> BATTERY
            else -> throw IllegalArgumentException()
        }
        
    }
    
}