package bug.capitulated.core_common.util

import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder

fun String.toEditable(): Editable = SpannableStringBuilder(this)

fun String.toSpannableStringBuilder() = SpannableStringBuilder(this)