package bug.capitulated.core_workmanager

import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

internal fun WorkManager.getWorkStatus(workRequest: WorkRequest, callback: WorkInfo.() -> Unit) {
    getWorkStatus(workRequest.id, callback)
}

internal fun WorkManager.getWorkStatus(workId: UUID, callback: WorkInfo.() -> Unit) {
    Observable.fromPublisher<WorkInfo> { subscriber ->
        getWorkInfoByIdLiveData(workId).observeForever {
            subscriber.onNext(it)
        }
    }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(Schedulers.io())
        .doOnNext(callback::invoke)
        .subscribe()
}