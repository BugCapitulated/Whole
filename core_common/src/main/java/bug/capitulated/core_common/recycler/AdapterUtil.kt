package bug.capitulated.core_common.recycler

import androidx.annotation.LayoutRes
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateLayoutContainerViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer

inline fun <reified T : KeyEntity<*>> createAdapter(
    @LayoutRes layout: Int,
    noinline block: AdapterDelegateLayoutContainerViewHolder<T>.() -> Unit
): DifferDelegateAdapter<T> {
    return adapterDelegateLayoutContainer(layout = layout, block = block)
        .toDifferDelegateAdapter()
}

fun <T : KeyEntity<*>> AdapterDelegate<List<T>>.toDifferDelegateAdapter() =
    DifferDelegateAdapter(this)

open class DifferDelegateAdapter<T : KeyEntity<*>>(
    vararg delegates: AdapterDelegate<List<T>>
) : AsyncListDifferDelegationAdapter<T>(
    DiffItemCallback<T>(),
    *delegates
)


inline fun <reified T> createAdapterWithoutDiffUtil(
    @LayoutRes layout: Int,
    noinline block: AdapterDelegateLayoutContainerViewHolder<T>.() -> Unit
): DelegateAdapter<T> {
    return adapterDelegateLayoutContainer(layout = layout, block = block)
        .toDelegateAdapter()
}

fun <T> AdapterDelegate<List<T>>.toDelegateAdapter(): DelegateAdapter<T> =
    DelegateAdapter(this)

open class DelegateAdapter<T>(
    vararg delegates: AdapterDelegate<List<T>>
) : ListDelegationAdapter<List<T>>(
    *delegates
)


fun <T> AdapterDelegateLayoutContainerViewHolder<T>.setOnItemClickListener(callback: (T) -> Unit) {
    itemView.setOnClickListener { callback(item) }
}