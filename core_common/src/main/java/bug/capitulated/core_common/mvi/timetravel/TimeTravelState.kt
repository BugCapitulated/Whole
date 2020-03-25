package bug.capitulated.core_common.mvi.timetravel

import android.text.SpannableStringBuilder
import bug.capitulated.core_common.recycler.KeyEntity
import bug.capitulated.core_common.util.toSpannableStringBuilder

internal data class TimeTravelState(
    val state: Any,
    val title: SpannableStringBuilder = state.toString().toSpannableStringBuilder()
) : KeyEntity<String> {

    override val id: String = state.toString()

}