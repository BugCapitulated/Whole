package bug.capitulated.feature_time_travel_example

import bug.capitulated.feature_time_travel_example.presentation.TimeTravelExampleFragment
import org.koin.dsl.module

val timeTravelExampleModule = module {
    factory { TimeTravelExampleFragment() }
}