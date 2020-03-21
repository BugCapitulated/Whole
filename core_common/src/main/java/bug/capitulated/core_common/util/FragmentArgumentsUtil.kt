package bug.capitulated.core_common.util

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

fun <F : Fragment> F.withArguments(bundleInitialization: () -> Bundle?): F {
    arguments = bundleInitialization.invoke()
    return this
}

fun <F : Fragment> F.withArgumentsNullable(vararg pairs: Pair<String, Any?>): F {
    arguments = notNullBundleOf(*pairs)
    return this
}

fun <F : Fragment> F.withArguments(vararg pairs: Pair<String, Any>): F {
    arguments = bundleOf(*pairs)
    return this
}


fun notNullBundleOf(vararg pairs: Pair<String, Any?>): Bundle {
    val filteredPairs = pairs.filter { it.second != null }
    return bundleOf(*filteredPairs.toTypedArray())
}