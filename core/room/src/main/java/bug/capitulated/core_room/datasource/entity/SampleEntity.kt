package bug.capitulated.core_room.datasource.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import bug.capitulated.core_common.recycler.KeyEntity

@Entity
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    override val id: Int = 0
) : KeyEntity<Int>