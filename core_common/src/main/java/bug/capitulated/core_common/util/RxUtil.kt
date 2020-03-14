package bug.capitulated.core_common.util

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.subjects.BehaviorSubject

fun <T : Any> ObservableSource<T>.toObservable() = Observable.wrap(this)!!

fun <T> T.toObservable() = Observable.just(this)

fun <T> Completable.map(item: () -> T) = andThen(Observable.just<T>(item.invoke()))

fun BehaviorSubject<String>.clear() {
    diffedValue = ""
}