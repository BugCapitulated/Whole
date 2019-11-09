package bug.capitulated.feature_mviexample.presentation.mvi

import bug.capitulated.core_data.datasource.room.entity.Sample

sealed class MviExampleAction {

    class SamplesReceived(val value: List<Sample>) : MviExampleAction()

}