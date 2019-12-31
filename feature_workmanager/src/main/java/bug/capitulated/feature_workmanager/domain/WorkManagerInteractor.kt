package bug.capitulated.feature_workmanager.domain

import io.reactivex.Completable

class WorkManagerInteractor(private val repository: WorkManagerRepository) {

    fun startWork() = Completable.fromAction {
        repository.startWork()
    }

    fun startPeriodicWork() = Completable.fromAction {
        repository.startPeriodicWork()
    }

}