package bug.capitulated.core_common.mvi.timetravel.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import androidx.annotation.ColorInt
import androidx.core.text.toSpannable

internal fun String.setBackgroundColor(@ColorInt color: Int = Color.GRAY): Spannable {
    return toSpannable().setBackgroundColor(color)
}

internal fun Spannable.setBackgroundColor(@ColorInt color: Int = Color.GRAY) = apply {
    setSpan(BackgroundColorSpan(color), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

internal fun Any.toSpannableStringBuilder() = toString().toSpannableStringBuilder()
internal fun String.toSpannableStringBuilder() = SpannableStringBuilder(this)