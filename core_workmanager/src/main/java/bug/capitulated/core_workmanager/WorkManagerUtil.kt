package bug.capitulated.core_workmanager

import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.paulinasadowska.rxworkmanagerobservers.extensions.getWorkInfoByIdObservable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Получение LiveData<List<WorkInfo>> из
 * @see androidx.work.WorkManager.getWorkInfosByTagLiveData по тегу
 * и мапиинг в Observable<List<WorkInfo>>
 */
fun WorkManager.getWorkInfosByTagObservable(tag: String): Observable<List<WorkInfo>> {
    return Observable.fromPublisher<List<WorkInfo>> { subscriber ->
        getWorkInfosByTagLiveData(tag).observeForever(subscriber::onNext)
    }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(Schedulers.io())
}

/**
 * Получение LiveData<List<WorkInfo>> из
 * @see androidx.work.WorkManager.getWorkInfosByTagLiveData по тегу
 * и мапиинг в (List<WorkInfo>) -> Unit
 */
internal fun WorkManager.getWorkInfosByTag(tag: String, callback: List<WorkInfo>.() -> Unit){
    getWorkInfosByTagObservable(tag)
        .doOnNext(callback::invoke)
        .subscribe()
}

/**
 * Получение LiveData<WorkInfo> из
 * @see androidx.work.WorkManager.getWorkInfoByIdLiveData по id
 * и мапиинг в (WorkInfo) -> Unit
 */
internal fun WorkManager.getWorkInfoById(workId: UUID, callback: WorkInfo.() -> Unit) {
    getWorkInfoByIdObservable(workId)
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(Schedulers.io())
        .doOnNext(callback::invoke)
        .subscribe()
}