package bug.capitulated.feature_nighttheme

import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val nightThemeModule = module {
    fragment { NightThemeFragment() }
}