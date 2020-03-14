package bug.capitulated.feature_mviexample.presentation

import bug.capitulated.core_common.util.toObservable
import bug.capitulated.core_room.datasource.entity.SampleEntity
import bug.capitulated.feature_mviexample.domain.MviExampleInteractor
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleIntent
import bug.capitulated.feature_mviexample.presentation.mvi.MviExampleViewState
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class MviExampleViewModelTest : BaseTest() {
    
    private val interactor = mock(MviExampleInteractor::class.java)
    private val viewModel = MviExampleViewModel(interactor)
    
    
    @Test
    fun loadData() {
        val initialState = MviExampleViewState(emptyList(), true)
        val dataState = MviExampleViewState(listOf(SampleEntity(123)), false)
        `when`(interactor.getSamples()).thenReturn(dataState.items.toObservable())
        
        viewModel.postIntent(MviExampleIntent.LoadData)
        
        viewModel.state
            .toObservable()
            //.doOnNext(::println)
            .take(2)
            .blockingForEach(::println)
            //.subscribe()
            //.test()
            //.assertValues(initialState, dataState)
    }
    
}