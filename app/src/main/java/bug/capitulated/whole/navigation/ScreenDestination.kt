package bug.capitulated.whole.navigation

import bug.capitulated.feature_main.BEAN_FRAGMENT_MAIN
import bug.capitulated.feature_mviexample.BEAN_FRAGMENT_MVI_EXAMPLE
import bug.capitulated.feature_mviexample.presentation.mviExampleArguments
import bug.capitulated.feature_nighttheme.BEAN_FRAGMENT_NIGHT_THEME
import bug.capitulated.feature_workmanager.BEAN_FRAGMENT_WORK_MANAGER
import org.koin.core.KoinComponent
import ru.terrakok.cicerone.android.support.FragmentParams
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class ScreenDestination : SupportAppScreen(), KoinComponent {

    object Main : ScreenDestination() {
        override fun getFragmentParams() = FragmentParams(BEAN_FRAGMENT_MAIN)
    }

    class MviExample(private val testArgument: String) : ScreenDestination() {
        override fun getFragmentParams() = FragmentParams(
            BEAN_FRAGMENT_MVI_EXAMPLE,
            mviExampleArguments(testArgument)
        )
    }

    object WorkManager : ScreenDestination() {
        override fun getFragmentParams() = FragmentParams(BEAN_FRAGMENT_WORK_MANAGER)
    }

    object NightTheme : ScreenDestination() {
        override fun getFragmentParams() = FragmentParams(BEAN_FRAGMENT_NIGHT_THEME)
    }

}