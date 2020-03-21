package bug.capitulated.core_common.mvi.timetravel

import bug.capitulated.core_common.R
import bug.capitulated.core_common.recycler.DifferDelegateAdapter
import bug.capitulated.core_common.recycler.createAdapter
import bug.capitulated.core_common.recycler.setOnItemClickListener
import kotlinx.android.synthetic.main.time_travel_item.*

internal fun mviStateAdapter(
    onViewStateClick: (TimeTravelState) -> Unit
): DifferDelegateAdapter<TimeTravelState> = createAdapter(R.layout.time_travel_item) {
    
    setOnItemClickListener(onViewStateClick)
    
    bind {
        title.text = item.id
    }
    
}