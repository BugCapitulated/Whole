package bug.capitulated.whole

import bug.capitulated.core_room.datasource.roomModule
import bug.capitulated.core_workmanager.workManagerCoreModule
import bug.capitulated.feature_main.mainModule
import bug.capitulated.feature_mviexample.mviExampleModule
import bug.capitulated.feature_nighttheme.nightThemeModule
import bug.capitulated.feature_workmanager.workManagerModule
import bug.capitulated.whole.navigation.navigationModule

internal val koinModules by lazy {
    navigationModule + coreModules + featureModules
}

private val coreModules
    get() = listOf(
        roomModule,
        workManagerCoreModule
    )

private val featureModules
    get() = listOf(
        mainModule,
        mviExampleModule,
        workManagerModule,
        nightThemeModule
    )