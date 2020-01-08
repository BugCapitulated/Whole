package bug.capitulated.core_workmanager

import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.paulinasadowska.rxworkmanagerobservers.extensions.getWorkInfoByIdObservable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

fun WorkManager.getWorkInfosByTagObservable(tag: String): Observable<List<WorkInfo>> {
    return Observable.fromPublisher<List<WorkInfo>> { subscriber ->
        getWorkInfosByTagLiveData(tag).observeForever {
            subscriber.onNext(it)
        }
    }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(Schedulers.io())
}

internal fun WorkManager.getWorkInfosByTag(tag: String, callback: List<WorkInfo>.() -> Unit){
    getWorkInfosByTagObservable(tag)
        .doOnNext(callback::invoke)
        .subscribe()
}

internal fun WorkManager.getWorkInfoById(workId: UUID, callback: WorkInfo.() -> Unit) {
    getWorkInfoByIdObservable(workId)
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(Schedulers.io())
        .doOnNext(callback::invoke)
        .subscribe()
}