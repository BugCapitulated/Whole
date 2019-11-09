package bug.capitulated.core_data.datasource.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import bug.capitulated.core_common.recycler.KeyEntity

@Entity
data class Sample(
    @PrimaryKey(autoGenerate = true)
    override val id: Int = 0
) : KeyEntity<Int>