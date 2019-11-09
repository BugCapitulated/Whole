package bug.capitulated.whole

import android.app.Application
import bug.capitulated.core_data.dataModule
import bug.capitulated.feature_main.mainModule
import bug.capitulated.feature_mviexample.mviExampleModule
import bug.capitulated.whole.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class WholeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WholeApplication)

            modules(
                listOf(
                    navigationModule,
                    dataModule,
                    mainModule,
                    mviExampleModule
                )
            )
        }
    }

}