package bug.capitulated.whole

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import bug.capitulated.core_common.namedFragmentFactory
import bug.capitulated.core_common.theme.Theme
import bug.capitulated.feature_nighttheme.KEY_THEME
import bug.capitulated.feature_nighttheme.PREFS_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WholeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initCurrentTheme()
        initKoin()
    }

    private fun initCurrentTheme() {
        val sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedTheme = Theme.themeOfInt(sharedPrefs.getInt(KEY_THEME, Theme.defaultThemeInt))
        AppCompatDelegate.setDefaultNightMode(savedTheme.toNightMode())
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger()
            androidContext(this@WholeApplication)
            namedFragmentFactory()
            modules(koinModules)
        }
    }

}