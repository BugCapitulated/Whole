package bug.capitulated.core_workmanager.worker

import android.content.Context
import androidx.work.RxWorker
import androidx.work.WorkerParameters
import io.reactivex.Single
import java.util.concurrent.TimeUnit

internal class SampleRxWorker(
    context: Context,
    workerParameters: WorkerParameters
) : RxWorker(context, workerParameters) {
    
    override fun createWork(): Single<Result> {
        return Single.just(Unit)
            .delay(5, TimeUnit.SECONDS)
            .map { Result.success() }
    }
    
}