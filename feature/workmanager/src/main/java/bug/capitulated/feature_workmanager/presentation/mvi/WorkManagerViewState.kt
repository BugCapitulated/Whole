package bug.capitulated.feature_workmanager.presentation.mvi

import bug.capitulated.feature_workmanager.presentation.recycler.MyWorkInfo

internal data class WorkManagerViewState(
    val workInfos: List<MyWorkInfo> = emptyList()
)