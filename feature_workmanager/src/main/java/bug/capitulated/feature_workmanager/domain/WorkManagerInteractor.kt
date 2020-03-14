package bug.capitulated.feature_workmanager.domain

import bug.capitulated.feature_workmanager.data.WorkManagerRepository
import io.reactivex.Completable

interface WorkManagerInteractor {
    
    fun startWork(): Completable
    
    fun startPeriodicWork(): Completable
    
    fun clearAllWorks(): Completable
    
}

internal class WorkManagerInteractorImpl(
    private val repository: WorkManagerRepository
) : WorkManagerInteractor {
    
    override fun startWork() = Completable.fromAction {
        repository.startWork()
    }
    
    override fun startPeriodicWork() = Completable.fromAction {
        repository.startPeriodicWork()
    }
    
    override fun clearAllWorks() = Completable.fromAction {
        repository.clearAllWorks()
    }
    
}