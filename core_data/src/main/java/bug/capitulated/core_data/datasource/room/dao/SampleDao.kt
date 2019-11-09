package bug.capitulated.core_data.datasource.room.dao

import androidx.room.Dao
import androidx.room.Query
import bug.capitulated.core_data.datasource.room.dao.base.BaseDao
import bug.capitulated.core_data.datasource.room.entity.Sample
import io.reactivex.Observable
import io.reactivex.Single

@Dao
internal interface SampleDao : BaseDao<Sample> {

    @Query("SELECT * FROM Sample")
    fun getSamples(): Observable<List<Sample>>

    @Query("SELECT * FROM Sample WHERE id = (:id)")
    fun getSample(id: String): Single<Sample>

}