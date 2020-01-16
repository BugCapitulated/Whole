package bug.capitulated.feature_nighttheme

import org.koin.dsl.module

val nightThemeModule = module {
    factory { NightThemeFragment() }
}