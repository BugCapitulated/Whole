package bug.capitulated.feature_main

import androidx.fragment.app.Fragment
import bug.capitulated.core_common.util.namedFragment
import org.koin.dsl.module

val BEAN_FRAGMENT_MAIN: Class<out Fragment> = MainFragment::class.java

val mainModule = module {
    namedFragment(BEAN_FRAGMENT_MAIN) { MainFragment() }
}