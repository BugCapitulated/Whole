package bug.capitulated.core_common.recycler

import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    protected val context by lazy { itemView.context!! }

    protected val resources by lazy { itemView.resources!! }

    protected fun getString(@StringRes id: Int): String = resources.getString(id)

    abstract fun bind(item: T)

}