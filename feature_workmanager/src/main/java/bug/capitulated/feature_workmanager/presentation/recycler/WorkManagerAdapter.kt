package bug.capitulated.feature_workmanager.presentation.recycler

import android.view.View
import bug.capitulated.core_common.recycler.BaseAdapter
import bug.capitulated.feature_workmanager.R

internal class WorkManagerAdapter : BaseAdapter<MyWorkInfo, WorkManagerViewHolder>() {
    
    override fun onLayoutRequested(viewType: Int) = R.layout.workmanager_item_list
    
    override fun onCreateViewHolder(view: View, viewType: Int) = WorkManagerViewHolder(view)
    
}