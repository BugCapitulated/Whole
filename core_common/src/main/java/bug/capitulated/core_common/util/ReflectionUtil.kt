@file:Suppress("UNCHECKED_CAST")

package bug.capitulated.core_common.util

fun <T> Any.getPrivateField(name: String): T {
    return getPrivateFieldNullable<T>(name) as T
}

fun <T> Any.getPrivateFieldNullable(name: String): T? {
    this::class.java.getDeclaredField(name).let {
        it.isAccessible = true
        return it.get(this) as? T
    }
}