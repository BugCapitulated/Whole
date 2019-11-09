package bug.capitulated.core_common.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val RecyclerView.ViewHolder.context
    get() = itemView.context!!

fun RecyclerView.init(
    adapter: RecyclerView.Adapter<*>,
    layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
) {
    this.layoutManager = layoutManager
    this.adapter = adapter
}

val RecyclerView.ViewHolder.hasPosition: Boolean
    get() = adapterPosition != RecyclerView.NO_POSITION

fun RecyclerView.ViewHolder.approveClick(callback: (position: Int) -> Unit): Boolean {
    if (hasPosition) {
        callback.invoke(adapterPosition)
        return true
    }

    return false
}