package bug.capitulated.core_common.util

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

fun <T : Any> ObservableSource<T>.toObservable() = Observable.wrap(this)!!

fun <T> T.toObservable(): Observable<out T> = Observable.just(this)

fun <T> Completable.map(item: () -> T) = andThen(Observable.just<T>(item.invoke()))

fun BehaviorSubject<String>.clear() {
    diffedValue = ""
}

@CheckReturnValue
fun <T> Observable<T>.subscribeOnIo(): Disposable {
    return subscribeOn(Schedulers.io()).subscribe()
}