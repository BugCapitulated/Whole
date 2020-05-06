package bug.capitulated.whole.navigation

import bug.capitulated.core_common.util.getNamedFragment
import bug.capitulated.feature_main.BEAN_FRAGMENT_MAIN
import bug.capitulated.feature_mviexample.BEAN_FRAGMENT_MVI_EXAMPLE
import bug.capitulated.feature_nighttheme.BEAN_FRAGMENT_NIGHT_THEME
import bug.capitulated.feature_workmanager.BEAN_FRAGMENT_WORK_MANAGER
import org.koin.core.KoinComponent
import org.koin.core.parameter.parametersOf
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class ScreenDestination : SupportAppScreen(), KoinComponent {
    
    object Main : ScreenDestination() {
        override fun getFragment() = getNamedFragment(BEAN_FRAGMENT_MAIN)
    }
    
    object MviExample : ScreenDestination() {
        override fun getFragment() = getNamedFragment(BEAN_FRAGMENT_MVI_EXAMPLE) {
            parametersOf("test param")
        }
    }
    
    object WorkManager : ScreenDestination() {
        override fun getFragment() = getNamedFragment(BEAN_FRAGMENT_WORK_MANAGER)
    }
    
    object NightTheme : ScreenDestination() {
        override fun getFragment() = getNamedFragment(BEAN_FRAGMENT_NIGHT_THEME)
    }
    
}