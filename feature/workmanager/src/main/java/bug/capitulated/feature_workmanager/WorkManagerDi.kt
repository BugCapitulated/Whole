package bug.capitulated.feature_workmanager

import androidx.fragment.app.Fragment
import bug.capitulated.core_common.util.namedFragment
import bug.capitulated.feature_workmanager.data.WorkManagerRepository
import bug.capitulated.feature_workmanager.data.WorkManagerRepositoryImpl
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractorImpl
import bug.capitulated.feature_workmanager.presentation.WorkManagerFragment
import bug.capitulated.feature_workmanager.presentation.WorkManagerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BEAN_FRAGMENT_WORK_MANAGER: Class<out Fragment> = WorkManagerFragment::class.java

val workManagerModule = module {
    namedFragment(BEAN_FRAGMENT_WORK_MANAGER) { WorkManagerFragment(get()) }
    viewModel { WorkManagerViewModel(get(), get()) }
    single<WorkManagerInteractor> { WorkManagerInteractorImpl(get()) }
    single<WorkManagerRepository> { WorkManagerRepositoryImpl(get()) }
}