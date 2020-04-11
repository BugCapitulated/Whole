package bug.capitulated.core_common.mvi.timetravel

import android.text.SpannableStringBuilder
import bug.capitulated.core_common.mvi.timetravel.util.toSpannableStringBuilder
import bug.capitulated.core_common.recycler.KeyEntity

internal data class TimeTravelState(
    val state: Any,
    val title: SpannableStringBuilder = state.toSpannableStringBuilder()
) : KeyEntity<String> {

    override val id: String = state.toString()

}