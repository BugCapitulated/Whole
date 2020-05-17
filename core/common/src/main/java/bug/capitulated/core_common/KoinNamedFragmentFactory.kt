package bug.capitulated.core_common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import bug.capitulated.core_common.util.getNamedFragment
import org.koin.android.ext.android.get
import org.koin.core.KoinApplication
import org.koin.core.KoinComponent
import org.koin.core.error.NoBeanDefFoundException
import org.koin.dsl.module

class KoinNamedFragmentFactory : FragmentFactory(), KoinComponent {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return try {
            getKoin().getNamedFragment(className)
        } catch (ex: NoBeanDefFoundException) {
            super.instantiate(classLoader, className)
        }
    }

}

/**
 * Setup the KoinNamedFragmentFactory instance
 */
fun KoinApplication.namedFragmentFactory() {
    koin.loadModules(listOf(module {
        single { KoinNamedFragmentFactory() }
    }))
}

fun FragmentActivity.setupKoinNamedFragmentFactory() {
    supportFragmentManager.fragmentFactory = get<KoinNamedFragmentFactory>()
}