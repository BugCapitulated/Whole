package bug.capitulated.feature_workmanager.data

import bug.capitulated.core_workmanager.WorkManagerDataSource

internal interface WorkManagerRepository {
    
    fun startWork()

    fun startPeriodicWork()
    
    fun clearAllWorks()

}

internal class WorkManagerRepositoryImpl(
    private val workManagerDataSource: WorkManagerDataSource
) : WorkManagerRepository {
    
    override fun startWork() {
        workManagerDataSource.startWork()
    }
    
    override fun startPeriodicWork() {
        workManagerDataSource.startPeriodicWork()
    }
    
    override fun clearAllWorks() {
        workManagerDataSource.clearAllWorks()
    }
    
}