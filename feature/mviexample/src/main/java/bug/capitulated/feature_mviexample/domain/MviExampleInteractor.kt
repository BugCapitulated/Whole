package bug.capitulated.feature_mviexample.domain

import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.data.MviExampleRepository
import io.reactivex.Completable
import io.reactivex.Observable

internal interface MviExampleInteractor {
    
    fun addSample(): Completable
    
    fun getSamples(): Observable<List<SampleEntity>>
    
}

internal class MviExampleInteractorImpl(
    private val repository: MviExampleRepository
) : MviExampleInteractor {
    
    override fun addSample() = Completable.fromAction {
        repository.addSample()
    }
    
    override fun getSamples(): Observable<List<SampleEntity>> {
        return repository.getSamples()
    }
    
}