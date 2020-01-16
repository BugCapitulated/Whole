package bug.capitulated.feature_nighttheme

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import bug.capitulated.core_common.base.BaseFragment
import kotlinx.android.synthetic.main.nighttheme_fragment.*

private const val PREFS_NAME = "PREFS_NAME"
private const val KEY_THEME = "KEY_THEME"

private const val THEME_UNDEFINED = -1
private const val THEME_LIGHT = 0
private const val THEME_DARK = 1
private const val THEME_SYSTEM = 2
private const val THEME_BATTERY = 3

class NightThemeFragment : BaseFragment(
    layoutId = R.layout.nighttheme_fragment
) {

    /*
      TODO:
       Запускать анимацию WindowAnimationTransition только при переключении темы
       Вынести префы в отдельный модуль, заиспользовать их здесь и в WholeApplication.applyTheme()
     */

    private val sharedPrefs by lazy {
        activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    private var savedTheme: Int
        get() = sharedPrefs.getInt(KEY_THEME, THEME_UNDEFINED)
        set(value) {
            sharedPrefs.edit().putInt(KEY_THEME, value).apply()
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
        themeSystem.isVisible = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

        when (savedTheme) {
            THEME_LIGHT -> themeLight.isChecked = true
            THEME_DARK -> themeDark.isChecked = true
            THEME_SYSTEM -> themeSystem.isChecked = true
            THEME_BATTERY -> themeBattery.isChecked = true

            THEME_UNDEFINED -> {
                when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                    Configuration.UI_MODE_NIGHT_NO, Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                        themeLight.isChecked = true
                    }

                    Configuration.UI_MODE_NIGHT_YES -> themeDark.isChecked = true
                }
            }
        }
    }

    private fun initThemeListener() {
        themeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.themeLight -> setTheme(AppCompatDelegate.MODE_NIGHT_NO, THEME_LIGHT)
                R.id.themeDark -> setTheme(AppCompatDelegate.MODE_NIGHT_YES, THEME_DARK)
                R.id.themeBattery -> setTheme(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY, THEME_BATTERY)
                R.id.themeSystem -> setTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, THEME_SYSTEM)
            }
        }
    }

    private fun setTheme(themeMode: Int, prefsMode: Int) {
        // Установка анимации при уничтожении и создании активити из кода
        //window.attributes.windowAnimations = R.style.WindowAnimationTransition

        savedTheme = prefsMode
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

}