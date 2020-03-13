package bug.capitulated.feature_mviexample.presentation.recycler

import android.view.View
import bug.capitulated.core_common.recycler.BaseAdapter
import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.R

internal class SampleAdapter(
    private val onClickListener: OnSampleClickListener
) : BaseAdapter<SampleEntity, SampleViewHolder>() {
    
    override fun onLayoutRequested(viewType: Int) = R.layout.mviexample_item_list
    
    override fun onCreateViewHolder(view: View, viewType: Int) = SampleViewHolder(view, ::onClick)
    
    private fun onClick(position: Int) = onClickListener.onSampleClick(items[position])
    
}