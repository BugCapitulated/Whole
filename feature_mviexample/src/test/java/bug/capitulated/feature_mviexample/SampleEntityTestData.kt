package bug.capitulated.feature_mviexample

import bug.capitulated.core_room.datasource.entity.SampleEntity

@Suppress("UNUSED")
internal enum class SampleEntityTestData(
    val items: List<SampleEntity>
) {
    
    EMPTY_LIST(emptyList()),
    LIST_WITH_ONE_ELEMENT(listOf(SampleEntity(0))),
    LIST_WITH_SEVERAL_ELEMENTS(listOf(SampleEntity(0), SampleEntity(1), SampleEntity(2))),
    
}