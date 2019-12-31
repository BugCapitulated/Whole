package bug.capitulated.feature_workmanager.domain

import bug.capitulated.core_workmanager.WorkManagerDataSource

class WorkManagerRepository(private val workManagerDataSource: WorkManagerDataSource) {

    fun startWork() {
        workManagerDataSource.startWork()
    }

    fun startPeriodicWork() {
        workManagerDataSource.startPeriodicWork()
    }

}