package bug.capitulated.feature_workmanager.presentation

import androidx.work.WorkManager
import bug.capitulated.core_common.mvi.MviViewModel
import bug.capitulated.core_workmanager.WORKER_TAG
import bug.capitulated.core_workmanager.getWorkInfosByTagObservable
import bug.capitulated.feature_workmanager.domain.WorkManagerInteractor
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerAction
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerIntent
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerViewState
import bug.capitulated.feature_workmanager.presentation.recycler.toMyWorkInfos

internal class WorkManagerViewModel(
    private val workManager: WorkManager,
    private val interactor: WorkManagerInteractor
) : MviViewModel<WorkManagerIntent, WorkManagerAction, WorkManagerViewState, Nothing>(
    WorkManagerViewState()
) {
    
    init {
        postIntent(WorkManagerIntent.Initialize)
    }
    
    override fun act(state: WorkManagerViewState, intent: WorkManagerIntent) = when (intent) {
        WorkManagerIntent.Initialize -> workManager.getWorkInfosByTagObservable(WORKER_TAG)
            .map(WorkManagerAction::WorkInfosReceived)
        
        WorkManagerIntent.StartWork -> interactor.startWork()
            .andThen(super.act(state, intent))
        
        WorkManagerIntent.StartPeriodicWork -> interactor.startPeriodicWork()
            .andThen(super.act(state, intent))
        
        WorkManagerIntent.ClearAllWorks -> interactor.clearAllWorks()
            .andThen(super.act(state, intent))
    }
    
    override fun reduce(oldState: WorkManagerViewState, action: WorkManagerAction) = when (action) {
        is WorkManagerAction.WorkInfosReceived -> oldState.copy(
            workInfos = action.value
                .toMyWorkInfos()
                .sortedByDescending { it.time }
        )
    }
    
}