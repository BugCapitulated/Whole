@file:Suppress("UNCHECKED_CAST")

package bug.capitulated.core_common.util

import android.app.Activity
import android.os.Parcelable
import androidx.fragment.app.Fragment
import java.io.Serializable

fun <T : Serializable> Fragment.argumentSerializable(key: String) = lazy { arguments?.getSerializable(key)!! as T }
fun <T : Parcelable> Fragment.argumentParcelable(key: String) = lazy { arguments?.getParcelable<T>(key)!! }
fun <T : Parcelable> Fragment.argumentParcelableArrayList(key: String) = lazy { arguments?.getParcelableArrayList<T>(key)!! }
fun Fragment.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy { arguments?.getBoolean(key, defaultValue) ?: defaultValue }
fun Fragment.argumentInt(key: String, defaultValue: Int = 0) = lazy { arguments?.getInt(key, defaultValue) ?: defaultValue }
fun Fragment.argumentIntArray(key: String) = lazy { arguments?.getIntArray(key)!! }
fun Fragment.argumentLongArray(key: String) = lazy { arguments?.getLongArray(key)!! }
fun Fragment.argumentLong(key: String, defaultValue: Long = 0L) = lazy { arguments?.getLong(key, defaultValue) ?: defaultValue }
fun Fragment.argumentShort(key: String, defaultValue: Short = 0) = lazy { arguments?.getShort(key, defaultValue) ?: defaultValue }
fun Fragment.argumentChar(key: String, defaultValue: Char = ' ') = lazy { arguments?.getChar(key, defaultValue) ?: defaultValue }
fun Fragment.argumentByte(key: String, defaultValue: Byte = 0) = lazy { arguments?.getByte(key, defaultValue) ?: defaultValue }
fun Fragment.argumentFloat(key: String, defaultValue: Float = 0f) = lazy { arguments?.getFloat(key, defaultValue) ?: defaultValue }
fun Fragment.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { arguments?.getDouble(key, defaultValue) ?: defaultValue }
fun Fragment.argumentCharSequence(key: String, defaultValue: CharSequence = "") = lazy { arguments?.getCharSequence(key, defaultValue) ?: defaultValue }
fun Fragment.argumentString(key: String, defaultValue: String = "") = lazy { arguments?.getString(key, defaultValue) ?: defaultValue }
fun Fragment.argumentStringArrayList(key: String) = lazy { arguments?.getStringArrayList(key)!! }

fun <T : Serializable> Fragment.nullableArgumentSerializable(key: String) = lazy { arguments?.getSerializable(key) as? T }
fun <T : Parcelable> Fragment.nullableArgumentParcelable(key: String) = lazy { arguments?.getParcelable<T>(key) }
fun <T : Parcelable> Fragment.nullableArgumentParcelableArrayList(key: String) = lazy { arguments?.getParcelableArrayList<T>(key) }
fun Fragment.nullableArgumentBoolean(key: String) = lazy { arguments?.getBoolean(key) }
fun Fragment.nullableArgumentInt(key: String) = lazy { arguments?.getInt(key) }
fun Fragment.nullableArgumentLong(key: String) = lazy { arguments?.getLong(key) }
fun Fragment.nullableArgumentShort(key: String) = lazy { arguments?.getShort(key) }
fun Fragment.nullableArgumentChar(key: String) = lazy { arguments?.getChar(key) }
fun Fragment.nullableArgumentByte(key: String) = lazy { arguments?.getByte(key) }
fun Fragment.nullableArgumentFloat(key: String) = lazy { arguments?.getFloat(key) }
fun Fragment.nullableArgumentDouble(key: String) = lazy { arguments?.getDouble(key) }
fun Fragment.nullableArgumentCharSequence(key: String) = lazy { arguments?.getCharSequence(key) }
fun Fragment.nullableArgumentString(key: String) = lazy { arguments?.getString(key) }
fun Fragment.nullableArgumentStringArrayList(key: String) = lazy { arguments?.getStringArrayList(key) }


fun <T : Serializable> Activity.argumentSerializable(key: String) = lazy { intent?.getSerializableExtra(key)!! as T }
fun <T : Parcelable> Activity.argumentParcelable(key: String) = lazy { intent?.getParcelableExtra<T>(key)!! }
fun Activity.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy { intent?.getBooleanExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentInt(key: String, defaultValue: Int = 0) = lazy { intent?.getIntExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentLong(key: String, defaultValue: Long = 0L) = lazy { intent?.getLongExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentShort(key: String, defaultValue: Short = 0) = lazy { intent?.getShortExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentChar(key: String, defaultValue: Char = ' ') = lazy { intent?.getCharExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentByte(key: String, defaultValue: Byte = 0) = lazy { intent?.getByteExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentFloat(key: String, defaultValue: Float = 0f) = lazy { intent?.getFloatExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { intent?.getDoubleExtra(key, defaultValue) ?: defaultValue }
fun Activity.argumentCharSequence(key: String) = lazy { intent?.getCharSequenceExtra(key)!! }
fun Activity.argumentString(key: String) = lazy { intent?.getStringExtra(key)!! }


fun <T : Serializable> Activity.nullableArgumentSerializable(key: String) = lazy { intent?.getSerializableExtra(key) as? T }
fun <T : Parcelable> Activity.nullableArgumentParcelable(key: String) = lazy { intent?.getParcelableExtra<T>(key) }
fun Activity.nullableArgumentBoolean(key: String, defaultValue: Boolean = false) = lazy { intent?.getBooleanExtra(key, defaultValue) }
fun Activity.nullableArgumentInt(key: String, defaultValue: Int = 0) = lazy { intent?.getIntExtra(key, defaultValue) }
fun Activity.nullableArgumentLong(key: String, defaultValue: Long = 0L) = lazy { intent?.getLongExtra(key, defaultValue) }
fun Activity.nullableArgumentShort(key: String, defaultValue: Short = 0) = lazy { intent?.getShortExtra(key, defaultValue) }
fun Activity.nullableArgumentChar(key: String, defaultValue: Char = ' ') = lazy { intent?.getCharExtra(key, defaultValue) }
fun Activity.nullableArgumentByte(key: String, defaultValue: Byte = 0) = lazy { intent?.getByteExtra(key, defaultValue) }
fun Activity.nullableArgumentFloat(key: String, defaultValue: Float = 0f) = lazy { intent?.getFloatExtra(key, defaultValue) }
fun Activity.nullableArgumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { intent?.getDoubleExtra(key, defaultValue) }
fun Activity.nullableArgumentCharSequence(key: String) = lazy { intent?.getCharSequenceExtra(key) }
fun Activity.nullableArgumentString(key: String) = lazy { intent?.getStringExtra(key) }


fun <T : Serializable> Fragment.argumentSerializableValue(key: String) = arguments?.getSerializable(key)!! as T
fun <T : Parcelable> Fragment.argumentParcelableValue(key: String) = arguments?.getParcelable<T>(key)!!
fun <T : Parcelable> Fragment.argumentParcelableArrayListValue(key: String) = arguments?.getParcelableArrayList<T>(key)!!
fun Fragment.argumentBooleanValue(key: String, defaultValue: Boolean = false) = arguments?.getBoolean(key, defaultValue) ?: defaultValue
fun Fragment.argumentIntValue(key: String, defaultValue: Int = 0) = arguments?.getInt(key, defaultValue) ?: defaultValue
fun Fragment.argumentIntArrayValue(key: String) = arguments?.getIntArray(key)!!
fun Fragment.argumentLongArrayValue(key: String) = arguments?.getLongArray(key)!!
fun Fragment.argumentLongValue(key: String, defaultValue: Long = 0L) = arguments?.getLong(key, defaultValue) ?: defaultValue
fun Fragment.argumentShortValue(key: String, defaultValue: Short = 0) = arguments?.getShort(key, defaultValue) ?: defaultValue
fun Fragment.argumentCharValue(key: String, defaultValue: Char = ' ') = arguments?.getChar(key, defaultValue) ?: defaultValue
fun Fragment.argumentByteValue(key: String, defaultValue: Byte = 0) = arguments?.getByte(key, defaultValue) ?: defaultValue
fun Fragment.argumentFloatValue(key: String, defaultValue: Float = 0f) = arguments?.getFloat(key, defaultValue) ?: defaultValue
fun Fragment.argumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = arguments?.getDouble(key, defaultValue) ?: defaultValue
fun Fragment.argumentCharSequenceValue(key: String, defaultValue: CharSequence = "") = arguments?.getCharSequence(key, defaultValue) ?: defaultValue
fun Fragment.argumentStringValue(key: String, defaultValue: String = "") = arguments?.getString(key, defaultValue) ?: defaultValue
fun Fragment.argumentStringArrayListValue(key: String) = arguments?.getStringArrayList(key)!!

fun <T : Serializable> Fragment.nullableArgumentSerializableValue(key: String) = arguments?.getSerializable(key) as? T
fun <T : Parcelable> Fragment.nullableArgumentParcelableValue(key: String) = arguments?.getParcelable<T>(key)
fun <T : Parcelable> Fragment.nullableArgumentParcelableArrayListValue(key: String) = arguments?.getParcelableArrayList<T>(key)
fun Fragment.nullableArgumentBooleanValue(key: String) = arguments?.getBoolean(key)
fun Fragment.nullableArgumentIntValue(key: String) = arguments?.getInt(key)
fun Fragment.nullableArgumentLongValue(key: String) = arguments?.getLong(key)
fun Fragment.nullableArgumentShortValue(key: String) = arguments?.getShort(key)
fun Fragment.nullableArgumentCharValue(key: String) = arguments?.getChar(key)
fun Fragment.nullableArgumentByteValue(key: String) = arguments?.getByte(key)
fun Fragment.nullableArgumentFloatValue(key: String) = arguments?.getFloat(key)
fun Fragment.nullableArgumentDoubleValue(key: String) = arguments?.getDouble(key)
fun Fragment.nullableArgumentCharSequenceValue(key: String) = arguments?.getCharSequence(key)
fun Fragment.nullableArgumentStringValue(key: String) = arguments?.getString(key)
fun Fragment.nullableArgumentStringArrayListValue(key: String) = arguments?.getStringArrayList(key)


fun <T : Serializable> Activity.argumentSerializableValue(key: String) = intent?.getSerializableExtra(key)!! as T
fun <T : Parcelable> Activity.argumentParcelableValue(key: String) = intent?.getParcelableExtra<T>(key)!!
fun Activity.argumentBooleanValue(key: String, defaultValue: Boolean = false) = intent?.getBooleanExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentIntValue(key: String, defaultValue: Int = 0) = intent?.getIntExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentLongValue(key: String, defaultValue: Long = 0L) = intent?.getLongExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentShortValue(key: String, defaultValue: Short = 0) = intent?.getShortExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentCharValue(key: String, defaultValue: Char = ' ') = intent?.getCharExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentByteValue(key: String, defaultValue: Byte = 0) = intent?.getByteExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentFloatValue(key: String, defaultValue: Float = 0f) = intent?.getFloatExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = intent?.getDoubleExtra(key, defaultValue) ?: defaultValue
fun Activity.argumentCharSequenceValue(key: String) = intent?.getCharSequenceExtra(key)!!
fun Activity.argumentStringValue(key: String) = intent?.getStringExtra(key)!!


fun <T : Serializable> Activity.nullableArgumentSerializableValue(key: String) = intent?.getSerializableExtra(key) as? T
fun <T : Parcelable> Activity.nullableArgumentParcelableValue(key: String) = intent?.getParcelableExtra<T>(key)
fun Activity.nullableArgumentBooleanValue(key: String, defaultValue: Boolean = false) = intent?.getBooleanExtra(key, defaultValue)
fun Activity.nullableArgumentIntValue(key: String, defaultValue: Int = 0) = intent?.getIntExtra(key, defaultValue)
fun Activity.nullableArgumentLongValue(key: String, defaultValue: Long = 0L) = intent?.getLongExtra(key, defaultValue)
fun Activity.nullableArgumentShortValue(key: String, defaultValue: Short = 0) = intent?.getShortExtra(key, defaultValue)
fun Activity.nullableArgumentCharValue(key: String, defaultValue: Char = ' ') = intent?.getCharExtra(key, defaultValue)
fun Activity.nullableArgumentByteValue(key: String, defaultValue: Byte = 0) = intent?.getByteExtra(key, defaultValue)
fun Activity.nullableArgumentFloatValue(key: String, defaultValue: Float = 0f) = intent?.getFloatExtra(key, defaultValue)
fun Activity.nullableArgumentDoubleValue(key: String, defaultValue: Double = 0.toDouble()) = intent?.getDoubleExtra(key, defaultValue)
fun Activity.nullableArgumentCharSequenceValue(key: String) = intent?.getCharSequenceExtra(key)
fun Activity.nullableArgumentStringValue(key: String) = intent?.getStringExtra(key)
fun Fragment.argumentIsExist(key: String) = arguments?.containsKey(key) ?: false
fun Fragment.argumentIsNotExist(key: String) = !argumentIsExist(key)

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