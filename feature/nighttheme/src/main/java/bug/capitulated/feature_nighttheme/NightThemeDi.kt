package bug.capitulated.feature_nighttheme

import bug.capitulated.core_common.util.namedFragment
import org.koin.dsl.module

const val BEAN_FRAGMENT_NIGHT_THEME = "NightThemeFragment"

val nightThemeModule = module {
    namedFragment(BEAN_FRAGMENT_NIGHT_THEME) { NightThemeFragment() }
}