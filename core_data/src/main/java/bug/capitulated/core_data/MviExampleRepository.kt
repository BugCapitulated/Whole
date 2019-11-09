package bug.capitulated.core_data

import bug.capitulated.core_data.datasource.room.entity.Sample
import io.reactivex.Observable

interface MviExampleRepository {

    fun getSamples(): Observable<List<Sample>>

    fun addSample()

}