package bug.capitulated.whole.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import bug.capitulated.core_common.base.BaseFragment
import bug.capitulated.core_common.base.BaseNavigator
import bug.capitulated.core_common.util.isNull
import bug.capitulated.feature_main.MainNavigator
import bug.capitulated.whole.activity.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

abstract class NavigationActivity(
    @IdRes private val fragmentContainer: Int
) : BaseActivity(), BaseNavigator, MainNavigator {

    private val navigatorHolder by inject<NavigatorHolder>()
    private val navigator by inject<SupportAppNavigator> { parametersOf(this, fragmentContainer) }
    private val router by inject<CustomRouter>()
    
    protected val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(fragmentContainer) as? BaseFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        savedInstanceState.isNull {
            router.newRootScreen(ScreenDestination.Main)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        currentFragment?.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun closeScreen() {
        router.exit()
    }

    override fun navigateToMviExample(testArgument: String) {
        navigateTo(ScreenDestination.MviExample(testArgument))
    }

    override fun navigateToWorkManager() {
        navigateTo(ScreenDestination.WorkManager)
    }

    override fun navigateToNightTheme() {
        navigateTo(ScreenDestination.NightTheme)
    }


    private fun navigateTo(screen: ScreenDestination) = router.navigateTo(screen)

}