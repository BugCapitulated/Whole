package bug.capitulated.feature_mviexample.domain

import bug.capitulated.core_data.MviExampleRepository
import bug.capitulated.core_data.datasource.room.entity.Sample
import io.reactivex.Completable
import io.reactivex.Observable

class MviExampleInteractor(private val repository: MviExampleRepository) {

    fun addSample() = Completable.fromAction {
        repository.addSample()
    }

    fun getSamples(): Observable<List<Sample>> {
        return repository.getSamples()
    }

}