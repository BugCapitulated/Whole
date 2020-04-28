package bug.capitulated.feature_main

import org.koin.dsl.module

val mainModule = module {
    factory { MainFragment() }
}