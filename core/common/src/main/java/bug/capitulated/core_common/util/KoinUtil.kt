@file:Suppress("NOTHING_TO_INLINE")

package bug.capitulated.core_common.util

import androidx.fragment.app.Fragment
import org.koin.core.Koin
import org.koin.core.definition.BeanDefinition
import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.named

inline fun Koin.getNamedFragment(
    fragmentTag: String,
    noinline parameters: ParametersDefinition? = null
): Fragment = get(named(fragmentTag), parameters)

inline fun Module.namedFragment(
    fragmentClass: Class<out Fragment>,
    override: Boolean = false,
    noinline definition: Definition<Fragment>
): BeanDefinition<Fragment> = factory(named(fragmentClass.name), override, definition)