package bug.capitulated.feature_workmanager.presentation

import android.os.Bundle
import android.view.View
import bug.capitulated.core_common.mvi.MviFragment
import bug.capitulated.core_common.util.init
import bug.capitulated.feature_workmanager.R
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerIntent
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerViewState
import bug.capitulated.feature_workmanager.presentation.recycler.workManagerAdapter
import kotlinx.android.synthetic.main.workmanager_fragment.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

internal class WorkManagerFragment(
    viewModel: WorkManagerViewModel
) : MviFragment<WorkManagerIntent, WorkManagerViewState, Nothing>(
    layoutId = R.layout.workmanager_fragment,
    viewModel = viewModel
) {
    
    private val adapter = workManagerAdapter()

    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler_view.init(adapter)
        
        one_time_work.setOnClickListener {
            postIntent(WorkManagerIntent.StartWork)
        }
        
        periodic_work.setOnClickListener {
            postIntent(WorkManagerIntent.StartPeriodicWork)
        }
        
        clearAllWork.setOnClickListener {
            postIntent(WorkManagerIntent.ClearAllWorks)
        }
    }
    
    override fun render(state: WorkManagerViewState) {
        adapter.items = state.workInfos
    }
    
}