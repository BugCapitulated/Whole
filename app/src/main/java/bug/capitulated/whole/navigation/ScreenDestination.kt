package bug.capitulated.whole.navigation

import bug.capitulated.feature_main.MainFragment
import bug.capitulated.feature_mviexample.presentation.MviExampleFragment
import bug.capitulated.feature_nighttheme.NightThemeFragment
import bug.capitulated.feature_workmanager.presentation.WorkManagerFragment
import org.koin.core.KoinComponent
import org.koin.core.get
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class ScreenDestination : SupportAppScreen(), KoinComponent {
    
    object Main : ScreenDestination() {
        override fun getFragment(): MainFragment = get()
    }
    
    object MviExample : ScreenDestination() {
        override fun getFragment(): MviExampleFragment = get()
    }
    
    object WorkManager : ScreenDestination() {
        override fun getFragment(): WorkManagerFragment = get()
    }
    
    object NightTheme : ScreenDestination() {
        override fun getFragment(): NightThemeFragment = get()
    }
    
}