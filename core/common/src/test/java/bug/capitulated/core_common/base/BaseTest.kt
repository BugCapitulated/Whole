package bug.capitulated.core_common.base

import androidx.annotation.CallSuper
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatcher
import org.mockito.Mockito

open class BaseTest {

    @BeforeEach
    @CallSuper
    protected open fun beforeEach() {
        initJavaSchedulers()
        initAndroidSchedulers()
    }

    @AfterEach
    @CallSuper
    protected open fun afterEach() {
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