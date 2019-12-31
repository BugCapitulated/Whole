package bug.capitulated.feature_mviexample.presentation.mvi

import bug.capitulated.core_room.datasource.entity.SampleEntity

data class MviExampleViewState(
    val items: List<SampleEntity> = emptyList(),
    val isLoading: Boolean = true
)