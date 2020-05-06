package bug.capitulated.feature_mviexample.presentation.mvi

internal sealed class MviExampleIntent {
    
    object AddSample : MviExampleIntent()
    
    object LoadData : MviExampleIntent()
    
}