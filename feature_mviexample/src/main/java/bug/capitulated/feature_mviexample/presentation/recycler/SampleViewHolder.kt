package bug.capitulated.feature_mviexample.presentation.recycler

import android.view.View
import bug.capitulated.core_common.recycler.BaseViewHolder
import bug.capitulated.core_common.util.onClick
import bug.capitulated.core_data.datasource.room.entity.Sample
import kotlinx.android.synthetic.main.item_list.*

internal class SampleViewHolder(
    containerView: View,
    private val onLayoutClick: (Int) -> Unit
) : BaseViewHolder<Sample>(containerView) {

    init {
        layout.onClick = { approveClick { onLayoutClick.invoke(adapterPosition) } }
    }

    override fun bind(item: Sample) {
        title.text = item.id.toString()
    }

}
