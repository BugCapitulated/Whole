package bug.capitulated.feature_mviexample.presentation

import bug.capitulated.core_common.mvi.MviViewModel
import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleAction
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleIntent
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleSubscription
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleViewState

class MviExampleViewModel(
    private val interactor: MviExampleInteractor
) : MviViewModel<MviExampleIntent, MviExampleAction, MviExampleViewState, MviExampleSubscription>(
    MviExampleViewState()
) {
    
    override fun act(state: MviExampleViewState, intent: MviExampleIntent) = when (intent) {
        MviExampleIntent.LoadData -> interactor.getSamples()
            .map<MviExampleAction>(MviExampleAction::SamplesReceived)
            .startWith(MviExampleAction.LoadDataStarted)
            .onErrorReturn(MviExampleAction::LoadDataFailed)
        
        MviExampleIntent.AddSample -> interactor.addSample()
            .toObservable()
    }
    
    override fun reduce(oldState: MviExampleViewState, action: MviExampleAction) = when (action) {
        MviExampleAction.LoadDataStarted -> oldState.copy(isLoading = true)
        
        is MviExampleAction.SamplesReceived -> oldState.copy(
            items = action.value,
            isLoading = false
        )
        
        is MviExampleAction.LoadDataFailed -> oldState.copy(isLoading = false)
    }
    
    override fun publishSubscription(action: MviExampleAction, state: MviExampleViewState) = when (action) {
        is MviExampleAction.LoadDataFailed -> MviExampleSubscription.LoadDataFailed(action.error)
        else -> super.publishSubscription(action, state)
    }
    
}