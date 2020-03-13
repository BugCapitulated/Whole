@file:Suppress("UNCHECKED_CAST")

package bug.capitulated.core_common.util

import android.os.Parcelable
import androidx.fragment.app.Fragment
import java.io.Serializable

// Lazy

fun <T : Serializable> Fragment.argumentSerializable(key: String) = lazy {
    arguments?.getSerializable(key)!! as T
}

fun <T : Parcelable> Fragment.argumentParcelable(key: String) = lazy {
    arguments?.getParcelable<T>(key)!!
}

fun <T : Parcelable> Fragment.argumentParcelableArrayList(key: String) = lazy {
    arguments?.getParcelableArrayList<T>(key)!!
}

fun Fragment.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy {
    arguments?.getBoolean(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentInt(key: String, defaultValue: Int = 0) = lazy {
    arguments?.getInt(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentIntArray(key: String) = lazy {
    arguments?.getIntArray(key)!!
}

fun Fragment.argumentLongArray(key: String) = lazy {
    arguments?.getLongArray(key)!!
}

fun Fragment.argumentLong(key: String, defaultValue: Long = 0L) = lazy {
    arguments?.getLong(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentShort(key: String, defaultValue: Short = 0) = lazy {
    arguments?.getShort(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentChar(key: String, defaultValue: Char = ' ') = lazy {
    arguments?.getChar(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentByte(key: String, defaultValue: Byte = 0) = lazy {
    arguments?.getByte(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentFloat(key: String, defaultValue: Float = 0f) = lazy {
    arguments?.getFloat(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy {
    arguments?.getDouble(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentCharSequence(key: String, defaultValue: CharSequence = "") = lazy {
    arguments?.getCharSequence(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentString(key: String, defaultValue: String = "") = lazy {
    arguments?.getString(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentStringArrayList(key: String) = lazy {
    arguments?.getStringArrayList(key)!!
}

// Lazy nullable

fun <T : Serializable> Fragment.nullableArgumentSerializable(key: String) = lazy {
    arguments?.getSerializable(key) as? T
}

fun <T : Parcelable> Fragment.nullableArgumentParcelable(key: String) = lazy {
    arguments?.getParcelable<T>(key)
}

fun <T : Parcelable> Fragment.nullableArgumentParcelableArrayList(key: String) = lazy {
    arguments?.getParcelableArrayList<T>(key)
}

fun Fragment.nullableArgumentBoolean(key: String) = lazy {
    arguments?.getBoolean(key)
}

fun Fragment.nullableArgumentInt(key: String) = lazy {
    arguments?.getInt(key)
}

fun Fragment.nullableArgumentLong(key: String) = lazy {
    arguments?.getLong(key)
}

fun Fragment.nullableArgumentShort(key: String) = lazy {
    arguments?.getShort(key)
}

fun Fragment.nullableArgumentChar(key: String) = lazy {
    arguments?.getChar(key)
}

fun Fragment.nullableArgumentByte(key: String) = lazy {
    arguments?.getByte(key)
}

fun Fragment.nullableArgumentFloat(key: String) = lazy {
    arguments?.getFloat(key)
}

fun Fragment.nullableArgumentDouble(key: String) = lazy {
    arguments?.getDouble(key)
}

fun Fragment.nullableArgumentCharSequence(key: String) = lazy {
    arguments?.getCharSequence(key)
}

fun Fragment.nullableArgumentString(key: String) = lazy {
    arguments?.getString(key)
}

fun Fragment.nullableArgumentStringArrayList(key: String) = lazy {
    arguments?.getStringArrayList(key)
}

// Value

fun <T : Serializable> Fragment.argumentSerializableValue(key: String) = run {
    arguments?.getSerializable(key)!! as T
}

fun <T : Parcelable> Fragment.argumentParcelableValue(key: String) = run {
    arguments?.getParcelable<T>(key)!!
}

fun <T : Parcelable> Fragment.argumentParcelableArrayListValue(key: String) = run {
    arguments?.getParcelableArrayList<T>(key)!!
}

fun Fragment.argumentBooleanValue(key: String, defaultValue: Boolean = false) = run {
    arguments?.getBoolean(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentIntValue(key: String, defaultValue: Int = 0) = run {
    arguments?.getInt(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentIntArrayValue(key: String) = run {
    arguments?.getIntArray(key)!!
}

fun Fragment.argumentLongArrayValue(key: String) = run {
    arguments?.getLongArray(key)!!
}

fun Fragment.argumentLongValue(key: String, defaultValue: Long = 0L) = run {
    arguments?.getLong(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentShortValue(key: String, defaultValue: Short = 0) = run {
    arguments?.getShort(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentCharValue(key: String, defaultValue: Char = ' ') = run {
    arguments?.getChar(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentByteValue(key: String, defaultValue: Byte = 0) = run {
    arguments?.getByte(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentFloatValue(key: String, defaultValue: Float = 0f) = run {
    arguments?.getFloat(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = run {
    arguments?.getDouble(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentCharSequenceValue(key: String, defaultValue: CharSequence = "") = run {
    arguments?.getCharSequence(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentStringValue(key: String, defaultValue: String = "") = run {
    arguments?.getString(key, defaultValue) ?: defaultValue
}

fun Fragment.argumentStringArrayListValue(key: String) = run {
    arguments?.getStringArrayList(key)!!
}

// Value nullable

fun <T : Serializable> Fragment.nullableArgumentSerializableValue(key: String) = run {
    arguments?.getSerializable(key) as? T
}

fun <T : Parcelable> Fragment.nullableArgumentParcelableValue(key: String) = run {
    arguments?.getParcelable<T>(key)
}

fun <T : Parcelable> Fragment.nullableArgumentParcelableArrayListValue(key: String) = run {
    arguments?.getParcelableArrayList<T>(key)
}

fun Fragment.nullableArgumentBooleanValue(key: String) = run {
    arguments?.getBoolean(key)
}

fun Fragment.nullableArgumentIntValue(key: String) = run {
    arguments?.getInt(key)
}

fun Fragment.nullableArgumentLongValue(key: String) = run {
    arguments?.getLong(key)
}

fun Fragment.nullableArgumentShortValue(key: String) = run {
    arguments?.getShort(key)
}

fun Fragment.nullableArgumentCharValue(key: String) = run {
    arguments?.getChar(key)
}

fun Fragment.nullableArgumentByteValue(key: String) = run {
    arguments?.getByte(key)
}

fun Fragment.nullableArgumentFloatValue(key: String) = run {
    arguments?.getFloat(key)
}

fun Fragment.nullableArgumentDoubleValue(key: String) = run {
    arguments?.getDouble(key)
}

fun Fragment.nullableArgumentCharSequenceValue(key: String) = run {
    arguments?.getCharSequence(key)
}

fun Fragment.nullableArgumentStringValue(key: String) = run {
    arguments?.getString(key)
}

fun Fragment.nullableArgumentStringArrayListValue(key: String) = run {
    arguments?.getStringArrayList(key)
}


fun Fragment.argumentIsExist(key: String) = arguments?.containsKey(key) ?: false
fun Fragment.argumentIsNotExist(key: String) = !argumentIsExist(key)