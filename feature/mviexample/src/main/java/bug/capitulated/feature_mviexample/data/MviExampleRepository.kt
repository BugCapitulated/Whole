package bug.capitulated.feature_mviexample.data

import bug.capitulated.core_room.datasource.SampleRoomDataSource
import bug.capitulated.core_room.datasource.entity.SampleEntity
import io.reactivex.Observable

internal interface MviExampleRepository {
    
    fun addSample()
    
    fun getSamples(): Observable<List<SampleEntity>>
    
}

internal class MviExampleRepositoryImpl(
    private val roomDataSource: SampleRoomDataSource
) : MviExampleRepository {
    
    override fun addSample() {
        roomDataSource.addSample(SampleEntity())
    }
    
    override fun getSamples(): Observable<List<SampleEntity>> {
        return roomDataSource.getSamples()
    }
    
}