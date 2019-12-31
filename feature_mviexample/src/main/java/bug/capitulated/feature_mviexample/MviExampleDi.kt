package bug.capitulated.feature_mviexample

import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.domain.MviExampleRepository
import bug.capitulated.feature_mviexample.presentation.MviExampleFragment
import bug.capitulated.feature_mviexample.presentation.MviExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mviExampleModule = module {
    factory { MviExampleFragment() }
    viewModel { MviExampleViewModel(get()) }
    single { MviExampleInteractor(get()) }
    single { MviExampleRepository(get()) }
}