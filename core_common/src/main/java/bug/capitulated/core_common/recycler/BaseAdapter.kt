package bug.capitulated.core_common.recycler

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import bug.capitulated.core_common.util.inflate

abstract class BaseAdapter<T : KeyEntity<*>, VH : BaseViewHolder<T>>
    : RecyclerView.Adapter<VH>() {

    var items: List<T> = listOf()
        set(value) {
            val callback = EntityDiffCallback(field, value) { it.id }
            val result = DiffUtil.calculateDiff(callback)

            field = value

            result.dispatchUpdatesTo(this)
        }

    protected lateinit var context: Context
        private set


    @CallSuper
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = parent.inflate(onLayoutRequested(viewType), parent)
        return onCreateViewHolder(view, viewType)
    }

    final override fun getItemCount() = items.size

    final override fun getItemId(position: Int) = items[position].id.hashCode().toLong()

    final override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])


    abstract fun onLayoutRequested(viewType: Int): Int

    abstract fun onCreateViewHolder(view: View, viewType: Int): VH


    fun getItemPosition(id: Any) = items.indexOfFirst { it.id == id }

}