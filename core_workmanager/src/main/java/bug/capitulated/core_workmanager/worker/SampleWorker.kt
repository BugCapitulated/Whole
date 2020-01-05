package bug.capitulated.core_workmanager.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import bug.capitulated.core_workmanager.WORK_MANAGER_PARAM_1

internal class SampleWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        // В версии 2.3.0-alpha01 появилась возможность возвращать промежуточный прогресс!

        // Получение параметра
        val someParameter = inputData.getString(WORK_MANAGER_PARAM_1)

        Thread.sleep(5000)

        // Формирование результата задачи
        val outputData = workDataOf(WORK_MANAGER_PARAM_1 to "some result")

        // Возвращение сообщения о том, что задача выполнена успешна, к ответу прикладываем результат
        // Также можно вернуть failure или retry
        return Result.success(outputData)
    }

}