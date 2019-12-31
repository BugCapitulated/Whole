package bug.capitulated.feature_workmanager.presentation.mvi

sealed class WorkManagerIntent {

    object StartWork : WorkManagerIntent()

    object StartPeriodicWork : WorkManagerIntent()

}