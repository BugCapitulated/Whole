package bug.capitulated.core_common.mvi.timetravel

import bug.capitulated.core_common.recycler.KeyEntity

internal data class TimeTravelState(
    val state: Any
): KeyEntity<String> {
    
    override val id: String = state.toString()
    
}