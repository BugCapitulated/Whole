package bug.capitulated.feature_workmanager.presentation.mvi

internal sealed class WorkManagerIntent {
    
    object Initialize : WorkManagerIntent()
    
    object ClearAllWorks : WorkManagerIntent()
    
    object StartWork : WorkManagerIntent()
    
    object StartPeriodicWork : WorkManagerIntent()
    
}