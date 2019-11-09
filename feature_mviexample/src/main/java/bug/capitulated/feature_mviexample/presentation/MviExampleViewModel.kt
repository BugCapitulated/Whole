package bug.capitulated.feature_mviexample.presentation

import bug.capitulated.core_common.mvi.MviViewModel
import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleAction
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleIntent
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleViewState

class MviExampleViewModel(
    private val interactor: MviExampleInteractor
) : MviViewModel<MviExampleIntent, MviExampleAction, MviExampleViewState, Nothing>(
    MviExampleViewState()
) {

    override fun act(state: MviExampleViewState, intent: MviExampleIntent) = when (intent) {
        MviExampleIntent.LoadData -> interactor.getSamples()
            .map { MviExampleAction.SamplesReceived(it) }

        MviExampleIntent.AddSample -> interactor.addSample()
            .toObservable()
    }

    override fun reduce(oldState: MviExampleViewState, action: MviExampleAction) = when (action) {
        is MviExampleAction.SamplesReceived -> oldState.copy(items = action.value)
    }

}