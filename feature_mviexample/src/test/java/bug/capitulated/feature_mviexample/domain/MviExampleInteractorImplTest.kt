package bug.capitulated.feature_mviexample.domain

import bug.capitulated.core_common.util.toObservable
import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.data.MviExampleRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.Mockito.*

internal class MviExampleInteractorImplTest {

    private val repository = mock(MviExampleRepository::class.java)
    private val interactor: MviExampleInteractor = MviExampleInteractorImpl(repository)


    @Test
    fun addSample() {
        interactor.addSample()
            .test()
            .assertSubscribed()
            .assertNoErrors()
            .assertComplete()

        verify(repository, only()).addSample()
    }

    @ParameterizedTest
    @EnumSource(SampleEntityTestData::class)
    fun getSamples(data: SampleEntityTestData) {
        `when`(repository.getSamples()).thenReturn(data.items.toObservable())

        interactor.getSamples()
            .test()
            .assertSubscribed()
            .assertNoErrors()
            .assertValue { it == data.items }
    }


    @Suppress("UNUSED")
    internal enum class SampleEntityTestData(
        val items: List<SampleEntity>
    ) {

        EMPTY_LIST(emptyList()),
        LIST_WITH_ONE_ELEMENT(listOf(SampleEntity(0))),
        LIST_WITH_SEVERAL_ELEMENTS(listOf(SampleEntity(0), SampleEntity(1), SampleEntity(2))),

    }


}