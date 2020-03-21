package bug.capitulated.core_common.mvi

import android.os.Bundle
import androidx.annotation.CheckResult
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import bug.capitulated.core_common.BuildConfig
import bug.capitulated.core_common.base.BaseFragment
import bug.capitulated.core_common.mvi.timetravel.DebaggableActivity
import bug.capitulated.core_common.mvi.timetravel.DebuggableView
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Реализация View в паттерне отображения MVI
 */
abstract class MviFragment<Intent : Any, State : Any, Subscription : Any>(
    @LayoutRes layoutId: Int,
    @MenuRes menuResource: Int? = null,
    hasOptionMenu: Boolean = true,
    
    private val initialIntent: Intent? = null
) : BaseFragment(layoutId, menuResource, hasOptionMenu) {
    
    protected val currentState: State?
        get() = _currentState
    
    private var _currentState: State? = null
    
    private val viewModel by lazy(::provideViewModel)
    
    private val mviDisposable = CompositeDisposable()
    
    private val debuggableView: DebuggableView? by lazy {
        val debuggableActivity = activity as? DebaggableActivity
        debuggableActivity?.debuggableView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        debuggableView?.onCreate(this, viewModel)
    }
    
    override fun onStart() {
        super.onStart()

        mviDisposable.addAll(
            viewModel.state bindTo ::onStateReceived,
            viewModel.subscription bindTo ::onSubscriptionReceived
        )
        
        initialIntent?.let(::postIntent)
    }
    
    override fun onStop() {
        super.onStop()
        mviDisposable.clear()
    }

    override fun onDestroy() {
        debuggableView?.onDestroy()
        super.onDestroy()
    }
    
    
    /**
     * Принимает и привязывает ViewModel к экрану
     */
    protected abstract fun provideViewModel(): MviViewModel<Intent, *, State, Subscription>
    
    /**
     * Приходит новый [State] при каждом его обновлении
     */
    protected abstract fun render(state: State)
    
    /**
     * Принимает [Subscription], что пришёл с ViewModel
     */
    protected open fun onSubscriptionReceived(subscription: Subscription) {}
    
    internal fun timeTravelRender(state: Any) {
        if (!BuildConfig.DEBUG) return
        
        @Suppress("UNCHECKED_CAST")
        render(state as State)
    }
    
    protected fun postIntent(intent: Intent): Unit = viewModel.postIntent(intent)
    
    private fun onStateReceived(state: State) {
        _currentState = state
        render(state)
    }
    
    
    private companion object {
        
        @CheckResult
        private infix fun <T : Any> ObservableSource<T>.bindTo(consumer: (T) -> Unit): Disposable {
            return Observable.wrap(this)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(onNext = consumer)
        }
        
    }
    
}