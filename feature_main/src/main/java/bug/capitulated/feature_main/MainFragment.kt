package bug.capitulated.feature_main

import bug.capitulated.core_common.base.BaseFragment

class MainFragment : BaseFragment(
    layoutId = R.layout.main_fragment
) {

    private val navigator by lazy { activity as MainNavigator }


}