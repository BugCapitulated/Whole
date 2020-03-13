package bug.capitulated.core_room.datasource

import bug.capitulated.core_room.datasource.dao.SampleDao
import bug.capitulated.core_room.datasource.entity.SampleEntity
import io.reactivex.Observable

interface SampleRoomDataSource {
    
    fun addSample(sample: SampleEntity)
    
    fun getSamples(): Observable<List<SampleEntity>>
    
}


internal class SampleRoomDataSourceImpl(
    private val sampleDao: SampleDao
) : SampleRoomDataSource {
    
    override fun addSample(sample: SampleEntity) {
        sampleDao.insert(sample)
    }
    
    override fun getSamples(): Observable<List<SampleEntity>> {
        return sampleDao.getSamples()
    }
    
}