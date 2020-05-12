package bug.capitulated.feature_workmanager

import bug.capitulated.core_common.util.namedFragment
import bug.capitulated.feature_workmanager.data.WorkManagerRepository
import bug.capitulated.feature_workmanager.data.WorkManagerRepositoryImpl
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractorImpl
import bug.capitulated.feature_workmanager.presentation.WorkManagerFragment
import bug.capitulated.feature_workmanager.presentation.WorkManagerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val BEAN_FRAGMENT_WORK_MANAGER = "WorkManagerFragment"

val workManagerModule = module {
    namedFragment(BEAN_FRAGMENT_WORK_MANAGER) { WorkManagerFragment() }

    scope<WorkManagerFragment> {
        viewModel { WorkManagerViewModel(get(), get()) }
        scoped<WorkManagerInteractor> { WorkManagerInteractorImpl(get()) }
        scoped<WorkManagerRepository> { WorkManagerRepositoryImpl(get()) }
    }
}