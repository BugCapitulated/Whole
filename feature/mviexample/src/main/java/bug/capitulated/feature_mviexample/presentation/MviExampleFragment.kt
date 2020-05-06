package bug.capitulated.feature_mviexample.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import bug.capitulated.core_common.mvi.MviFragment
import bug.capitulated.core_common.util.init
import bug.capitulated.core_common.util.isNull
import bug.capitulated.core_common.util.toast
import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.R
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleIntent
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleSubscription
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleViewState
import bug.capitulated.feature_mviexample.presentation.recycler.sampleAdapter
import kotlinx.android.synthetic.main.mviexample_fragment.*

internal class MviExampleFragment(
    viewModel: MviExampleViewModel,
    private val testArgument: String
) : MviFragment<MviExampleIntent, MviExampleViewState, MviExampleSubscription>(
    viewModel = viewModel,
    layoutId = R.layout.mviexample_fragment
) {
    
    private val adapter = sampleAdapter(::onSampleClick)
    
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.init(enableArrowUp = false)
        recycler_view.init(adapter)
        
        savedInstanceState.isNull { postIntent(MviExampleIntent.LoadData) }
        fab.setOnClickListener { postIntent(MviExampleIntent.AddSample) }
        
        toast(testArgument)
    }
    
    override fun render(state: MviExampleViewState) {
        progressbar.isVisible = state.isLoading
        adapter.items = state.items
    }
    
    override fun onSubscriptionReceived(subscription: MviExampleSubscription) {
        when (subscription) {
            is MviExampleSubscription.LoadDataFailed -> toast("Ошибка при загрузке данных")
        }
    }
    
    
    private fun onSampleClick(item: SampleEntity) {
        toast("Item " + item.id.toString() + " clicked")
    }
    
}