package bug.capitulated.feature_workmanager.presentation

import bug.capitulated.core_common.mvi.MviViewModel
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerAction
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerIntent
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerViewState

class WorkManagerViewModel(
    private val interactor: WorkManagerInteractor
) : MviViewModel<WorkManagerIntent, WorkManagerAction, WorkManagerViewState, Nothing>(WorkManagerViewState()) {

    override fun act(state: WorkManagerViewState, intent: WorkManagerIntent) = when (intent) {
        WorkManagerIntent.StartWork -> interactor.startWork()
            .andThen(super.act(state, intent))

        WorkManagerIntent.StartPeriodicWork -> interactor.startPeriodicWork()
            .andThen(super.act(state, intent))
    }

}