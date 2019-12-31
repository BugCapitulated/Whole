package bug.capitulated.feature_mviexample.presentation.recycler

import bug.capitulated.core_room.datasource.entity.SampleEntity

internal interface OnSampleClickListener {

    fun onSampleClick(item: SampleEntity)

}