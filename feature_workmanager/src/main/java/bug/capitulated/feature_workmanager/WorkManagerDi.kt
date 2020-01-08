package bug.capitulated.feature_workmanager

import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.domain.WorkManagerRepository
import bug.capitulated.feature_workmanager.presentation.WorkManagerFragment
import bug.capitulated.feature_workmanager.presentation.WorkManagerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val workManagerModule = module {
    factory { WorkManagerFragment() }
    viewModel { WorkManagerViewModel(get(), get()) }
    single { WorkManagerInteractor(get()) }
    single { WorkManagerRepository(get()) }
}