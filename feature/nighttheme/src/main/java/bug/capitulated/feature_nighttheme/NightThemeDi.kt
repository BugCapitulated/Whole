package bug.capitulated.feature_nighttheme

import androidx.fragment.app.Fragment
import bug.capitulated.core_common.util.namedFragment
import org.koin.dsl.module

val BEAN_FRAGMENT_NIGHT_THEME: Class<out Fragment> = NightThemeFragment::class.java

val nightThemeModule = module {
    namedFragment(BEAN_FRAGMENT_NIGHT_THEME) { NightThemeFragment() }
}