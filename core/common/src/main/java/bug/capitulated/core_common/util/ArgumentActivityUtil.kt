@file:Suppress("UNCHECKED_CAST")

package bug.capitulated.core_common.util

import android.app.Activity
import android.os.Parcelable
import java.io.Serializable

// Lazy

fun <T : Serializable> Activity.argumentSerializable(key: String) = lazy {
    intent?.getSerializableExtra(key)!! as T
}

fun <T : Parcelable> Activity.argumentParcelable(key: String) = lazy {
    intent?.getParcelableExtra<T>(key)!!
}

fun Activity.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy {
    intent?.getBooleanExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentInt(key: String, defaultValue: Int = 0) = lazy {
    intent?.getIntExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentLong(key: String, defaultValue: Long = 0L) = lazy {
    intent?.getLongExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentShort(key: String, defaultValue: Short = 0) = lazy {
    intent?.getShortExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentChar(key: String, defaultValue: Char = ' ') = lazy {
    intent?.getCharExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentByte(key: String, defaultValue: Byte = 0) = lazy {
    intent?.getByteExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentFloat(key: String, defaultValue: Float = 0f) = lazy {
    intent?.getFloatExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy {
    intent?.getDoubleExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentCharSequence(key: String) = lazy {
    intent?.getCharSequenceExtra(key)!!
}

fun Activity.argumentString(key: String) = lazy {
    intent?.getStringExtra(key)!!
}

// Lazy nullable

fun <T : Serializable> Activity.nullableArgumentSerializable(key: String) = lazy {
    intent?.getSerializableExtra(key) as? T
}

fun <T : Parcelable> Activity.nullableArgumentParcelable(key: String) = lazy {
    intent?.getParcelableExtra<T>(key)
}

fun Activity.nullableArgumentBoolean(key: String, defaultValue: Boolean = false) = lazy {
    intent?.getBooleanExtra(key, defaultValue)
}

fun Activity.nullableArgumentInt(key: String, defaultValue: Int = 0) = lazy {
    intent?.getIntExtra(key, defaultValue)
}

fun Activity.nullableArgumentLong(key: String, defaultValue: Long = 0L) = lazy {
    intent?.getLongExtra(key, defaultValue)
}

fun Activity.nullableArgumentShort(key: String, defaultValue: Short = 0) = lazy {
    intent?.getShortExtra(key, defaultValue)
}

fun Activity.nullableArgumentChar(key: String, defaultValue: Char = ' ') = lazy {
    intent?.getCharExtra(key, defaultValue)
}

fun Activity.nullableArgumentByte(key: String, defaultValue: Byte = 0) = lazy {
    intent?.getByteExtra(key, defaultValue)
}

fun Activity.nullableArgumentFloat(key: String, defaultValue: Float = 0f) = lazy {
    intent?.getFloatExtra(key, defaultValue)
}

fun Activity.nullableArgumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy {
    intent?.getDoubleExtra(key, defaultValue)
}

fun Activity.nullableArgumentCharSequence(key: String) = lazy {
    intent?.getCharSequenceExtra(key)
}

fun Activity.nullableArgumentString(key: String) = lazy {
    intent?.getStringExtra(key)
}

// Value

fun <T : Serializable> Activity.argumentSerializableValue(key: String) = run {
    intent?.getSerializableExtra(key)!! as T
}

fun <T : Parcelable> Activity.argumentParcelableValue(key: String) = run {
    intent?.getParcelableExtra<T>(key)!!
}

fun Activity.argumentBooleanValue(key: String, defaultValue: Boolean = false) = run {
    intent?.getBooleanExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentIntValue(key: String, defaultValue: Int = 0) = run {
    intent?.getIntExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentLongValue(key: String, defaultValue: Long = 0L) = run {
    intent?.getLongExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentShortValue(key: String, defaultValue: Short = 0) = run {
    intent?.getShortExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentCharValue(key: String, defaultValue: Char = ' ') = run {
    intent?.getCharExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentByteValue(key: String, defaultValue: Byte = 0) = run {
    intent?.getByteExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentFloatValue(key: String, defaultValue: Float = 0f) = run {
    intent?.getFloatExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = run {
    intent?.getDoubleExtra(key, defaultValue) ?: defaultValue
}

fun Activity.argumentCharSequenceValue(key: String) = run {
    intent?.getCharSequenceExtra(key)!!
}

fun Activity.argumentStringValue(key: String) = run {
    intent?.getStringExtra(key)!!
}

// Value nullable

fun <T : Serializable> Activity.nullableArgumentSerializableValue(key: String) = run {
    intent?.getSerializableExtra(key) as? T
}

fun <T : Parcelable> Activity.nullableArgumentParcelableValue(key: String) = run {
    intent?.getParcelableExtra<T>(key)
}

fun Activity.nullableArgumentBooleanValue(key: String, defaultValue: Boolean = false) = run {
    intent?.getBooleanExtra(key, defaultValue)
}

fun Activity.nullableArgumentIntValue(key: String, defaultValue: Int = 0) = run {
    intent?.getIntExtra(key, defaultValue)
}

fun Activity.nullableArgumentLongValue(key: String, defaultValue: Long = 0L) = run {
    intent?.getLongExtra(key, defaultValue)
}

fun Activity.nullableArgumentShortValue(key: String, defaultValue: Short = 0) = run {
    intent?.getShortExtra(key, defaultValue)
}

fun Activity.nullableArgumentCharValue(key: String, defaultValue: Char = ' ') = run {
    intent?.getCharExtra(key, defaultValue)
}

fun Activity.nullableArgumentByteValue(key: String, defaultValue: Byte = 0) = run {
    intent?.getByteExtra(key, defaultValue)
}

fun Activity.nullableArgumentFloatValue(key: String, defaultValue: Float = 0f) = run {
    intent?.getFloatExtra(key, defaultValue)
}

fun Activity.nullableArgumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = run {
    intent?.getDoubleExtra(key, defaultValue)
}

fun Activity.nullableArgumentCharSequenceValue(key: String) = run {
    intent?.getCharSequenceExtra(key)
}

fun Activity.nullableArgumentStringValue(key: String) = run {
    intent?.getStringExtra(key)
}


fun Activity.argumentIsExist(key: String) = intent?.extras?.containsKey(key) ?: false
fun Activity.argumentIsNotExist(key: String) = !argumentIsExist(key)

fun Activity.argumentIsExist(key: String, callback: () -> Unit): Boolean? {
    if (intent?.extras?.containsKey(key) == true) {
        callback.invoke()
        return true
    }
    
    return null
}

fun Activity.argumentIsNotExist(key: String, callback: () -> Unit): Boolean? {
    if (intent?.extras?.containsKey(key) != true) {
        callback.invoke()
        return true
    }
    
    return null
}