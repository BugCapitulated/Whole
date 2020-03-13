package bug.capitulated.whole.navigation

import androidx.fragment.app.FragmentActivity
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.android.support.SupportAppNavigator

val navigationModule = module {
    factory { (activity: FragmentActivity, containerId: Int) ->
        SupportAppNavigator(activity, containerId)
    }
    
    single { CustomRouter() }
    single { Cicerone.create(get<CustomRouter>()) }
    single { get<Cicerone<CustomRouter>>().navigatorHolder }
}