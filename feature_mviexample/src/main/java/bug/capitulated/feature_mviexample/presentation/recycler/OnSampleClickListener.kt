package bug.capitulated.feature_mviexample.presentation.recycler

import bug.capitulated.core_data.datasource.room.entity.Sample

internal interface OnSampleClickListener {

    fun onSampleClick(item: Sample)

}