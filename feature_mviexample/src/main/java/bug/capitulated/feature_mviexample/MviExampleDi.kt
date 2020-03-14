package bug.capitulated.feature_mviexample

import bug.capitulated.feature_mviexample.data.MviExampleRepository
import bug.capitulated.feature_mviexample.data.MviExampleRepositoryImpl
import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.domain.MviExampleInteractorImpl
import bug.capitulated.feature_mviexample.presentation.MviExampleFragment
import bug.capitulated.feature_mviexample.presentation.MviExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mviExampleModule = module {
    factory { MviExampleFragment() }
    viewModel { MviExampleViewModel(get()) }
    single<MviExampleInteractor> { MviExampleInteractorImpl(get()) }
    single<MviExampleRepository> { MviExampleRepositoryImpl(get()) }
}