package bug.capitulated.core_data.datasource.room.dao.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

internal interface BaseDao<T> {

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(items: List<T>): List<Long>

    @Delete
    fun remove(item: T)

}