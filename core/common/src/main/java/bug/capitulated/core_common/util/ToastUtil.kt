package bug.capitulated.core_common.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Context.toast(@StringRes stringId: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, stringId, duration).show()
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}

fun Fragment.toast(@StringRes stringId: Int, duration: Int = Toast.LENGTH_LONG) {
    context?.toast(stringId, duration)
}

fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_LONG) {
    context?.toast(text, duration)
}