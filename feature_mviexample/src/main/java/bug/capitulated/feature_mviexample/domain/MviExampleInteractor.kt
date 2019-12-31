package bug.capitulated.feature_mviexample.domain

import bug.capitulated.core_room.datasource.entity.SampleEntity
import io.reactivex.Completable
import io.reactivex.Observable

class MviExampleInteractor(private val repository: MviExampleRepository) {

    fun addSample() = Completable.fromAction {
        repository.addSample()
    }

    fun getSamples(): Observable<List<SampleEntity>> {
        return repository.getSamples()
    }

}