package bug.capitulated.feature_main

import bug.capitulated.core_common.util.namedFragment
import org.koin.dsl.module

const val BEAN_FRAGMENT_MAIN = "MainFragment"

val mainModule = module {
    namedFragment(BEAN_FRAGMENT_MAIN) { MainFragment() }
}