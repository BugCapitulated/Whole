package bug.capitulated.core_data

import bug.capitulated.core_data.datasource.room.dao.SampleDao
import bug.capitulated.core_data.datasource.room.entity.Sample
import io.reactivex.Observable

internal class Repository(
    private val sampleDao: SampleDao
) : MviExampleRepository {

    override fun addSample() {
        sampleDao.insert(Sample())
    }

    override fun getSamples(): Observable<List<Sample>> {
        return sampleDao.getSamples()
    }

}