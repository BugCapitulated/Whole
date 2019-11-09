package bug.capitulated.core_data

import bug.capitulated.core_data.datasource.room.SampleRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { SampleRoomDatabase.createDatabase(androidContext()) }
    single { get<SampleRoomDatabase>().getTitleDao() }

    single { Repository(get()) }
    single<MviExampleRepository> { get<Repository>() }
}