package bug.capitulated.feature_mviexample.presentation.mvi

sealed class MviExampleIntent {
    
    object AddSample : MviExampleIntent()
    
    object LoadData : MviExampleIntent()
    
}