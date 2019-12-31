package bug.capitulated.core_workmanager.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*

internal class SampleCoroutineWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result = /*withContext(Dispatchers.IO)*/ coroutineScope {
        val jobs = async {
            delay(5000)
        }

        jobs.await()
        Result.success()
    }

}