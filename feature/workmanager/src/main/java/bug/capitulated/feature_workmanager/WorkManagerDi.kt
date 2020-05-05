package bug.capitulated.feature_workmanager

import bug.capitulated.feature_workmanager.data.WorkManagerRepository
import bug.capitulated.feature_workmanager.data.WorkManagerRepositoryImpl
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractorImpl
import bug.capitulated.feature_workmanager.presentation.WorkManagerFragment
import bug.capitulated.feature_workmanager.presentation.WorkManagerViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val workManagerModule = module {
    fragment { WorkManagerFragment(get()) }
    viewModel { WorkManagerViewModel(get(), get()) }
    single<WorkManagerInteractor> { WorkManagerInteractorImpl(get()) }
    single<WorkManagerRepository> { WorkManagerRepositoryImpl(get()) }
}