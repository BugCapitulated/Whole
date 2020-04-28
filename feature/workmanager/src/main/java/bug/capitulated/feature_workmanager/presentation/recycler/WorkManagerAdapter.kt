package bug.capitulated.feature_workmanager.presentation.recycler

import android.annotation.SuppressLint
import bug.capitulated.core_common.recycler.createAdapter
import bug.capitulated.feature_workmanager.R
import kotlinx.android.synthetic.main.workmanager_item_list.*

@SuppressLint("SetTextI18n")
internal fun workManagerAdapter() = createAdapter<MyWorkInfo>(R.layout.workmanager_item_list) {
    
    bind {
        title.text = item.uuid.toString()
        state.text = "${item.state} ${item.time}"
    }
    
}