package bug.capitulated.core_common.util

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

fun View.getString(@StringRes stringResId: Int): String = context.getString(stringResId)

fun View.getColor(@ColorRes colorResId: Int) = context.resources.getColor(colorResId)