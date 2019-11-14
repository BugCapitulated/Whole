package bug.capitulated.core_common.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun Context.inflate(@LayoutRes resource: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View {
    val inflater = LayoutInflater.from(this)
    return inflater.inflate(resource, root, attachToRoot)
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View {
    return context.inflate(resource, this, attachToRoot)
}

fun View.inflate(@LayoutRes resource: Int, root: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return context.inflate(resource, root, attachToRoot)
}