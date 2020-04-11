package bug.capitulated.feature_main

import android.os.Bundle
import android.view.View
import bug.capitulated.core_common.base.BaseFragment
import bug.capitulated.core_common.util.setOnClickListener
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment(layoutId = R.layout.main_fragment) {
    
    private val navigator by lazy { activity as MainNavigator }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initNavigation()
    }
    
    private fun initNavigation() {
        mvi_example_button.setOnClickListener(navigator::navigateToMviExample)
        work_manager_button.setOnClickListener(navigator::navigateToWorkManager)
        night_theme_button.setOnClickListener(navigator::navigateToNightTheme)
        time_travel_example.setOnClickListener(navigator::navigateToTimeTravelExample)
    }
    
}