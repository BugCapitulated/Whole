package bug.capitulated.whole.navigation

import bug.capitulated.feature_main.MainFragment
import bug.capitulated.feature_mviexample.presentation.MviExampleFragment
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

}