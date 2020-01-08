package bug.capitulated.feature_workmanager.presentation.recycler

import android.annotation.SuppressLint
import android.view.View
import bug.capitulated.core_common.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.workmanager_item_list.*

internal class WorkManagerViewHolder(
    containerView: View
) : BaseViewHolder<MyWorkInfo>(containerView) {

    @SuppressLint("SetTextI18n")
    override fun bind(item: MyWorkInfo) {
        title.text = item.uuid.toString()
        state.text = "${item.state} ${item.time}"
    }

}