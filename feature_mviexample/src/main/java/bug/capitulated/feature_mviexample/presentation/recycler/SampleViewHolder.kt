package bug.capitulated.feature_mviexample.presentation.recycler

import android.view.View
import bug.capitulated.core_common.recycler.BaseViewHolder
import bug.capitulated.core_common.util.approveClick
import bug.capitulated.core_room.datasource.entity.SampleEntity
import kotlinx.android.synthetic.main.mviexample_item_list.*

internal class SampleViewHolder(
    containerView: View,
    private val onLayoutClick: (Int) -> Unit
) : BaseViewHolder<SampleEntity>(containerView) {
    
    init {
        layout.setOnClickListener { approveClick { onLayoutClick.invoke(adapterPosition) } }
    }
    
    override fun bind(item: SampleEntity) {
        title.text = item.id.toString()
    }
    
}