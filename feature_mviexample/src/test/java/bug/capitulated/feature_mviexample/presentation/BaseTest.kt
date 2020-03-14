package bug.capitulated.feature_mviexample.presentation

import androidx.annotation.CallSuper
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatcher
import org.mockito.Mockito
import org.robolectric.annotation.Config

@Config(application = TestApplication::class, manifest = Config.NONE, sdk = [28])
open class BaseTest(private val withRx: Boolean = true) {
    
    @Before
    @BeforeEach
    @CallSuper
    open fun beforeEach() {
        initRx()
    }
    
    @After
    @AfterEach
    @CallSuper
    open fun afterEach() {
        resetRx()
    }
    
    private fun initRx() {
        if (!withRx) return
        initJavaSchedulers()
        initAndroidSchedulers()
    }
    
    private fun resetRx() {
        if (!withRx) return
        resetJavaSchedulers()
        resetAndroidSchedulers()
    }
    
    protected fun <T> any(): T {
        Mockito.any<T>()
        return nullAsT()
    }
    
    protected fun <T> argThat(matcher: ArgumentMatcher<T>): T {
        Mockito.argThat(matcher)
        return nullAsT()
    }
    
    protected fun <T> eq(value: T): T {
        Mockito.eq(value)
        return nullAsT()
    }
    
    
    private fun initJavaSchedulers() {
        resetJavaSchedulers()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
    }
    
    private fun initAndroidSchedulers() {
        resetAndroidSchedulers()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }
    
    private fun resetJavaSchedulers() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setErrorHandler {}
    }
    
    private fun resetAndroidSchedulers() {
        RxAndroidPlugins.reset()
    }
    
    @Suppress("UNCHECKED_CAST")
    private fun <T> nullAsT(): T = null as T
    
}