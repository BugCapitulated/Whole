package bug.capitulated.feature_nighttheme

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import androidx.core.view.isVisible
import bug.capitulated.core_common.base.BaseFragment
import bug.capitulated.core_common.theme.Theme
import bug.capitulated.core_common.theme.Theme.Companion.defaultThemeInt
import bug.capitulated.core_common.theme.Theme.Companion.themeOfInt
import bug.capitulated.core_common.util.is28orMore
import kotlinx.android.synthetic.main.nighttheme_fragment.*

const val PREFS_NAME = "PREFS_NAME"
const val KEY_THEME = "KEY_THEME"

internal class NightThemeFragment : BaseFragment(
    layoutId = R.layout.nighttheme_fragment
) {
    
    /*
      TODO:
       Запускать анимацию WindowAnimationTransition только при переключении темы
       Вынести префы в отдельный модуль
    */
    
    private val sharedPrefs by lazy {
        activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    
    private var savedTheme: Theme
        get() = themeOfInt(sharedPrefs.getInt(KEY_THEME, defaultThemeInt))
        set(value) {
            sharedPrefs.edit().putInt(KEY_THEME, value.toInt()).apply()
        }
    
    
    init {
        // Узнаём текущую тему
        //AppCompatDelegate.getDefaultNightMode()
    }
    
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initThemeListener()
        initTheme()
    }
    
    private fun initTheme() {
        themeSystem.isVisible = is28orMore()
        
        when (savedTheme) {
            Theme.LIGHT -> themeLight.isChecked = true
            Theme.DARK -> themeDark.isChecked = true
            Theme.SYSTEM -> themeSystem.isChecked = true
            Theme.BATTERY -> themeBattery.isChecked = true
        }
    }
    
    private fun initThemeListener() {
        themeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.themeLight -> setTheme(Theme.LIGHT)
                R.id.themeDark -> setTheme(Theme.DARK)
                R.id.themeSystem -> setTheme(Theme.SYSTEM)
                R.id.themeBattery -> setTheme(Theme.BATTERY)
            }
        }
    }
    
    private fun setTheme(theme: Theme) {
        // Установка анимации при уничтожении и создании активити из кода
        //window.attributes.windowAnimations = R.style.WindowAnimationTransition
        
        savedTheme = theme
        setDefaultNightMode(theme.toNightMode())
    }
    
}