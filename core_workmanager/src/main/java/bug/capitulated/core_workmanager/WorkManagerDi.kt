package bug.capitulated.core_workmanager

import androidx.work.WorkManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val workManagerCoreModule = module {
    single { WorkManager.getInstance(androidContext()) }
    single { WorkManagerDataSourceImpl(get()) }
    single<WorkManagerDataSource> { get<WorkManagerDataSourceImpl>() }
}