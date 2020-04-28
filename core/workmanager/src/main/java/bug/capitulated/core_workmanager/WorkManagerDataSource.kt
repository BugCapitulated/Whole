package bug.capitulated.core_workmanager

import androidx.work.*
import bug.capitulated.core_common.util.log
import bug.capitulated.core_workmanager.worker.SampleWorker
import java.util.concurrent.TimeUnit

interface WorkManagerDataSource {
    
    fun startWork()
    
    fun startPeriodicWork()
    
    fun clearAllWorks()
    
}


const val WORK_MANAGER_PARAM_1 = "WORK_MANAGER_PARAM_1"
const val WORK_MANAGER_PARAM_CURRENT_TIME = "WORK_MANAGER_PARAM_CURRENT_TIME"
const val WORKER_TAG = "WORKER_TAG"


/**
 * Полезные ссылки:
 * https://developer.android.com/topic/libraries/architecture/workmanager/basics
 * https://proandroiddev.com/workout-your-tasks-with-workmanager-intro-db5aefe14d66
 * https://proandroiddev.com/workout-your-tasks-with-workmanager-main-components-1c0c66317a3e
 * https://proandroiddev.com/how-to-use-workmanager-with-rxjava-b5936f68e024
 */
internal class WorkManagerDataSourceImpl(
    private val workManager: WorkManager
) : WorkManagerDataSource {
    
    /**
     * Запуск задачи, что выполнится один раз
     */
    override fun startWork() {
        // Условия для запуска задачи. Задача запускается только если все условия выполнены
        val constraints = Constraints.Builder()
            //.setRequiresDeviceIdle(true) // Устройство в режиме ожидания
            //.setRequiresCharging(true) // Устройство заряжается
            //.setRequiredNetworkType(NetworkType.CONNECTED) // Устройство подключено к сети type
            //.setRequiresBatteryNotLow(true) // Уровень заряда батареи не ниже критического
            //.setRequiresStorageNotLow(true) // Количество свободного пространста не ниже критического
            .build()
        
        // Формирование параметров для передачи их в воркер с типом ключ - значение
        // Ограничение при передачи данных - 10Kb
        val params = workDataOf(WORK_MANAGER_PARAM_1 to "some parameter")
        
        OneTimeWorkRequestBuilder<SampleWorker>()
            //.setInitialDelay(3, TimeUnit.SECONDS) // Delay
            //.setConstraints(constraints) // Условия для запуска задачи
            
            // Установка условий для Result.retry()
            .setBackoffCriteria(
                BackoffPolicy.LINEAR, // Функция возрастания времени ретрая
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS // Время для ретрая
            )
            
            // Передача параметров в воркер
            .setInputData(params)
            
            // Задачи можно группировать по тегам. В дальнейшем по тегу можно прерывать группу задач
            // Также по тегу можно получать статус задачи
            .addTag(WORKER_TAG)
            
            .build()
            .enqueue()
    }
    
    /**
     * Запуск периодической задачи
     *
     * Минимальное значение repeatInterval - 15 минут
     *
     * Если указать flexInterval - задача будет выполнена в (flexInterval, repeatInterval) интервал,
     * если же не указывать flexInterval - задача будет выполнена в (0, repeatInterval) интервал.
     * в любой момент данных интервалов
     */
    override fun startPeriodicWork() {
        PeriodicWorkRequestBuilder<SampleWorker>(20, TimeUnit.MINUTES, 15, TimeUnit.MINUTES)
            .addTag(WORKER_TAG)
            .build()
            .enqueue()
    }
    
    /**
     * Остановка и перевод задачи в статус CANCELED
     *
     * Остановить задачу можно по id задачи,
     * можно по тегу, присвоенному некоторым задачам,
     * также по имени именованной задачи
     * или можно остановить сразу все задачи
     */
    override fun clearAllWorks() {
        workManager.cancelAllWork()
        
        //workManager.cancelWorkById()
        //workManager.cancelAllWorkByTag()
        //workManager.cancelUniqueWork()
    }
    
    /**
     * Запуск последовательности задач
     */
    fun startChainingWork() {
        val workRequest = makeSampleOneTimeWorkRequest()
        
        // Запуск трёх задач параллельно, затем двух задач последовательно
        workManager
            .beginWith(listOf(workRequest, workRequest, workRequest))
            .then(workRequest)
            .then(workRequest)
            .enqueue()
    }
    
    /**
     * enqueueUniqueWork - Запуск именованной задачи, позволяет избегать дублирования в создании задач
     *
     * [ExistingWorkPolicy.REPLACE] - Cancel the existing chain and REPLACE it with the new one.
     * [ExistingWorkPolicy.KEEP] - KEEP the existing sequence and ignore your new request.
     * [ExistingWorkPolicy.APPEND] - APPEND your new sequence to the existing one,
     * running the new sequence's first task after the existing sequence's last task finishes.
     * You cannot use APPEND with PeriodicWorkRequests.
     */
    fun startUniqueWork() {
        val workRequest = makeSampleOneTimeWorkRequest()
        
        workManager.enqueueUniqueWork(
            "unique work name",
            ExistingWorkPolicy.REPLACE,
            workRequest
        )
    }
    
    
    private fun makeSampleOneTimeWorkRequest(): OneTimeWorkRequest {
        return OneTimeWorkRequestBuilder<SampleWorker>().build()
    }
    
    private fun <T : WorkRequest> T.observe(withResult: WorkInfo.() -> Unit = {}): T {
        workManager.getWorkInfoById(id) {
            "$id: $state".log
            
            if (outputData.keyValueMap.isNotEmpty()) {
                withResult.invoke(this)
            }
        }
        
        return this
    }
    
    private fun WorkRequest.enqueue() {
        workManager.enqueue(this)
    }
    
}