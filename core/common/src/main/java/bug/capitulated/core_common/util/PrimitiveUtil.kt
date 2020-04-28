package bug.capitulated.core_common.util

fun Boolean.toInt() = if (this) 1 else 0

fun Any?.isNull(callback: () -> Unit): Boolean? {
    if (this == null) {
        callback.invoke()
        return true
    }
    
    return null
}