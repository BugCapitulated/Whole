package bug.capitulated.feature_mviexample.presentation.mvi

sealed class MviExampleSubscription {
    
    class LoadDataFailed(val error: Throwable) : MviExampleSubscription()
    
}