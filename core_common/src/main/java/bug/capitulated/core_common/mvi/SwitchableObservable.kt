package bug.capitulated.core_common.mvi

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

internal fun <T : Any> Observable<T>.switchSource(source: Observable<T>): Observable<T> =
    if (this is SwitchableObservable<T>) apply(::switchSourceObservable)
    else from(source)

internal fun <T : Any> from(source: Observable<T>): SwitchableObservable<T> = SwitchableObservable(source)


internal class SwitchableObservable<T : Any>(private var source: Observable<T>) : Observable<T>() {
    
    private val disposable = CompositeDisposable()
    
    private var observer: Observer<in T>? = null
    
    
    override fun subscribeActual(observer: Observer<in T>?) {
        this.observer = observer
        updateSubscription()
    }
    
    
    internal fun switchSourceObservable(source: Observable<T>) {
        this.source = source
        updateSubscription()
    }
    
    fun dispose(): Unit = disposable.dispose()
    
    private fun updateSubscription() {
        disposable.clear()
        if (observer == null) return
        
        disposable += source
            .subscribeOn(Schedulers.io())
            .subscribeBy { observer?.onNext(it) }
    }
    
}