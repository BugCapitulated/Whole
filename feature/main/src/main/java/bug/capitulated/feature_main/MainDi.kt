package bug.capitulated.feature_main

import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val mainModule = module {
    fragment { MainFragment() }
}