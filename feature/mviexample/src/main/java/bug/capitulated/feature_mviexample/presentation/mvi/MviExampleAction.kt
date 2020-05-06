package bug.capitulated.feature_mviexample.presentation.mvi

import bug.capitulated.core_room.datasource.entity.SampleEntity

internal sealed class MviExampleAction {
    
    object LoadDataStarted : MviExampleAction()
    
    class SamplesReceived(val value: List<SampleEntity>) : MviExampleAction()
    
    class LoadDataFailed(val error: Throwable) : MviExampleAction()
    
}