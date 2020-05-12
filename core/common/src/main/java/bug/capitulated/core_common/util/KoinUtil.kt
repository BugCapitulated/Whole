@file:Suppress("NOTHING_TO_INLINE")

package bug.capitulated.core_common.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.getStateViewModel
import org.koin.core.KoinComponent
import org.koin.core.definition.BeanDefinition
import org.koin.core.definition.Definition
import org.koin.core.get
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.named

inline fun KoinComponent.getNamedFragment(
    fragmentTag: String,
    noinline parameters: ParametersDefinition? = null
): Fragment = get(named(fragmentTag), parameters)

inline fun Module.namedFragment(
    fragmentTag: String,
    override: Boolean = false,
    noinline definition: Definition<Fragment>
): BeanDefinition<Fragment> = factory(named(fragmentTag), override, definition)

inline fun <reified T : ViewModel> SavedStateRegistryOwner.getScopedViewModel(): T {
    return lifecycleScope.getStateViewModel(this)
}