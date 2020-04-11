package bug.capitulated.whole

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import bug.capitulated.core_common.theme.Theme
import bug.capitulated.core_room.datasource.roomModule
import bug.capitulated.core_workmanager.workManagerCoreModule
import bug.capitulated.feature_main.mainModule
import bug.capitulated.feature_mviexample.mviExampleModule
import bug.capitulated.feature_nighttheme.KEY_THEME
import bug.capitulated.feature_nighttheme.PREFS_NAME
import bug.capitulated.feature_nighttheme.nightThemeModule
import bug.capitulated.feature_time_travel_example.timeTravelExampleModule
import bug.capitulated.feature_workmanager.workManagerModule
import bug.capitulated.whole.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
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
            androidContext(this@WholeApplication)
            
            modules(
                listOf(
                    navigationModule,
                    
                    roomModule,
                    workManagerCoreModule,
                    
                    mainModule,
                    mviExampleModule,
                    workManagerModule,
                    nightThemeModule,
                    timeTravelExampleModule
                )
            )
        }
    }
    
}