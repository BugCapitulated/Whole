package bug.capitulated.feature_mviexample.presentation.mvi

internal sealed class MviExampleSubscription {
    
    class LoadDataFailed(val error: Throwable) : MviExampleSubscription()
    
}