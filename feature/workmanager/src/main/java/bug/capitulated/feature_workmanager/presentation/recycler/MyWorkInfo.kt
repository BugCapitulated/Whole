package bug.capitulated.feature_workmanager.presentation.recycler

import androidx.work.WorkInfo
import bug.capitulated.core_common.recycler.KeyEntity
import bug.capitulated.core_workmanager.WORK_MANAGER_PARAM_CURRENT_TIME
import java.util.*

internal data class MyWorkInfo(
    val uuid: UUID,
    val state: String,
    val time: Long,
    val tags: Set<String>
) : KeyEntity<String> {
    
    override val id: String by lazy(uuid::toString)
    
}

internal fun List<WorkInfo>.toMyWorkInfos() = map {
    it.toMyWorkInfo()
}

internal fun WorkInfo.toMyWorkInfo() = MyWorkInfo(
    uuid = id,
    state = state.toString(),
    time = outputData.getLong(WORK_MANAGER_PARAM_CURRENT_TIME, 0L),
    tags = tags
)