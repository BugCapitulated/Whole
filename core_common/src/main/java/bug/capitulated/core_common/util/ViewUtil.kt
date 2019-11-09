package bug.capitulated.core_common.util

import android.view.View
import android.widget.CompoundButton
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

var View.onClick: () -> Unit
    get() = {}
    set(value) = setOnClickListener { value() }

var View.onLongClick: () -> Boolean
    get() = { false }
    set(value) = setOnLongClickListener { value() }

var CompoundButton.onCheck: (Boolean) -> Unit
    get() = {}
    set(value) = setOnCheckedChangeListener { _, isChecked -> value(isChecked) }

fun View.getString(@StringRes stringResId: Int): String = context.getString(stringResId)

fun View.getColor(@ColorRes colorResId: Int) = context.resources.getColor(colorResId)