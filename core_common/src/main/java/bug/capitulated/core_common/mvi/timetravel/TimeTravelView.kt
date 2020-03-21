package bug.capitulated.core_common.mvi.timetravel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bug.capitulated.core_common.R
import bug.capitulated.core_common.mvi.MviFragment
import bug.capitulated.core_common.mvi.MviViewModel
import bug.capitulated.core_common.util.init
import bug.capitulated.core_common.util.toObservable
import io.palaima.debugdrawer.base.DebugModuleAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

private typealias AnyMviFragment = MviFragment<*, *, *>
private typealias AnyMviViewModel = MviViewModel<*, *, *, *>

interface DebuggableView {
    
    fun onCreate(mviFragment: AnyMviFragment, mviViewModel: AnyMviViewModel)
    
    fun onDestroy()
    
}

class TimeTravelView : DebugModuleAdapter(), DebuggableView {
    
    private var mviFragment: AnyMviFragment? = null
    private var mviViewModel: AnyMviViewModel? = null
    
    private lateinit var recyclerView: RecyclerView
    private val adapter by lazy { mviStateAdapter(::onViewStateClick) }
    
    private val disposable = CompositeDisposable()
    
    private val timeTravelStates = mutableListOf<TimeTravelState>()
    
    
    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.time_travel_fragment, parent, false).apply {
            recyclerView = findViewById(R.id.recycler_view)
            recyclerView.init(adapter)
        }
    }
    
    override fun onCreate(mviFragment: AnyMviFragment, mviViewModel: AnyMviViewModel) {
        this.mviFragment = mviFragment
        this.mviViewModel = mviViewModel
        
        mviViewModel.state
            .toObservable()
            .doOnNext { viewState ->
                val state = TimeTravelState(viewState)
                timeTravelStates += state
                notifyAdapter()
            }
            .subscribe()
            .addTo(disposable)
    }
    
    override fun onDestroy() {
        mviFragment = null
        mviViewModel = null
        
        disposable.clear()
        
        timeTravelStates.clear()
        notifyAdapter()
    }
    
    
    private fun notifyAdapter() {
        adapter.items = timeTravelStates
        adapter.notifyDataSetChanged()
    }
    
    private fun onViewStateClick(timeTravelState: TimeTravelState) {
        mviFragment?.timeTravelRender(timeTravelState.state)
    }
    
}