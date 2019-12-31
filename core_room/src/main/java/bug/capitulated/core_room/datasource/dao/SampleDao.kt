package bug.capitulated.core_room.datasource.dao

import androidx.room.Dao
import androidx.room.Query
import bug.capitulated.core_room.datasource.dao.base.BaseDao
import bug.capitulated.core_room.datasource.entity.SampleEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
internal interface SampleDao : BaseDao<SampleEntity> {

    @Query("SELECT * FROM SampleEntity")
    fun getSamples(): Observable<List<SampleEntity>>

    @Query("SELECT * FROM SampleEntity WHERE id = (:id)")
    fun getSample(id: String): Single<SampleEntity>

}