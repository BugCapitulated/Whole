package bug.capitulated.feature_workmanager.presentation.mvi

import androidx.work.WorkInfo

internal sealed class WorkManagerAction {
    
    class WorkInfosReceived(val value: List<WorkInfo>) : WorkManagerAction()
    
}