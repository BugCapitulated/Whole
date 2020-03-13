package bug.capitulated.feature_mviexample.presentation.recycler

import bug.capitulated.core_common.recycler.createAdapter
import bug.capitulated.core_common.recycler.setOnItemClickListener
import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.R
import kotlinx.android.synthetic.main.mviexample_item_list.*

internal fun sampleAdapter(
    onAirlineClick: (SampleEntity) -> Unit
) = createAdapter<SampleEntity>(R.layout.mviexample_item_list) {

    setOnItemClickListener(onAirlineClick)

    bind {
        title.text = item.id.toString()
    }

}