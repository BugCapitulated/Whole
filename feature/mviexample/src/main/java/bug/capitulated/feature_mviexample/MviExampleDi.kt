package bug.capitulated.feature_mviexample

import androidx.fragment.app.Fragment
import bug.capitulated.core_common.util.namedFragment
import bug.capitulated.feature_mviexample.data.MviExampleRepository
import bug.capitulated.feature_mviexample.data.MviExampleRepositoryImpl
import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.domain.MviExampleInteractorImpl
import bug.capitulated.feature_mviexample.presentation.MviExampleFragment
import bug.capitulated.feature_mviexample.presentation.MviExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BEAN_FRAGMENT_MVI_EXAMPLE: Class<out Fragment> = MviExampleFragment::class.java

val mviExampleModule = module {
    namedFragment(BEAN_FRAGMENT_MVI_EXAMPLE) { MviExampleFragment(get()) }
    viewModel { MviExampleViewModel(get()) }
    single<MviExampleInteractor> { MviExampleInteractorImpl(get()) }
    single<MviExampleRepository> { MviExampleRepositoryImpl(get()) }
}