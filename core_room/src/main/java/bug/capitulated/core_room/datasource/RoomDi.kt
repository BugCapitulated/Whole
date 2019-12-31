package bug.capitulated.core_room.datasource

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        SampleRoomDatabase.createDatabase(
            androidContext()
        )
    }
    single { get<SampleRoomDatabase>().getTitleDao() }
    single { SampleRoomDataSourceImpl(get()) }
    single<SampleRoomDataSource> { get<SampleRoomDataSourceImpl>() }
}