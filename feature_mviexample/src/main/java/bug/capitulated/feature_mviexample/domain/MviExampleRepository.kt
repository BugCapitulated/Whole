package bug.capitulated.feature_mviexample.domain

import bug.capitulated.core_room.datasource.SampleRoomDataSource
import bug.capitulated.core_room.datasource.entity.SampleEntity
import io.reactivex.Observable

class MviExampleRepository(private val roomDataSource: SampleRoomDataSource) {
    
    fun addSample() {
        roomDataSource.addSample(SampleEntity())
    }
    
    fun getSamples(): Observable<List<SampleEntity>> {
        return roomDataSource.getSamples()
    }
    
}