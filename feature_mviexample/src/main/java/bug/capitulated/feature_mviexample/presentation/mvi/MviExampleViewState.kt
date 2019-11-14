package bug.capitulated.feature_mviexample.presentation.mvi

import bug.capitulated.core_data.datasource.room.entity.Sample

data class MviExampleViewState(
    val items: List<Sample> = emptyList(),
    val isLoading: Boolean = true
)