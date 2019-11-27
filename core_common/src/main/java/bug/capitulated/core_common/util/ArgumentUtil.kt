package bug.capitulated.core_common.util

import android.app.Activity
import android.os.Parcelable
import androidx.fragment.app.Fragment

/*
Падение при отсутствии аргумента

При создании фрагмента с необязательными параметрами использовать nullable аргументы
*/

fun <T : Parcelable> Fragment.argumentParcelable(key: String) = lazy { arguments?.getParcelable<T>(key)!! }
fun <T : Parcelable> Fragment.argumentParcelableArrayList(key: String) = lazy { arguments?.getParcelableArrayList<T>(key)!! }
fun Fragment.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy { arguments?.getBoolean(key, defaultValue)!! }
fun Fragment.argumentInt(key: String, defaultValue: Int = 0) = lazy { arguments?.getInt(key, defaultValue)!! }
fun Fragment.argumentIntArray(key: String) = lazy { arguments?.getIntArray(key)!! }
fun Fragment.argumentLongArray(key: String) = lazy { arguments?.getLongArray(key)!! }
fun Fragment.argumentLong(key: String, defaultValue: Long = 0L) = lazy { arguments?.getLong(key, defaultValue)!! }
fun Fragment.argumentShort(key: String, defaultValue: Short = 0) = lazy { arguments?.getShort(key, defaultValue)!! }
fun Fragment.argumentChar(key: String, defaultValue: Char = ' ') = lazy { arguments?.getChar(key, defaultValue)!! }
fun Fragment.argumentByte(key: String, defaultValue: Byte = 0) = lazy { arguments?.getByte(key, defaultValue)!! }
fun Fragment.argumentFloat(key: String, defaultValue: Float = 0f) = lazy { arguments?.getFloat(key, defaultValue)!! }
fun Fragment.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { arguments?.getDouble(key, defaultValue)!! }
fun Fragment.argumentCharSequence(key: String, defaultValue: CharSequence = "") = lazy { arguments?.getCharSequence(key, defaultValue)!! }
fun Fragment.argumentString(key: String, defaultValue: String = "") = lazy { arguments?.getString(key, defaultValue)!! }
fun Fragment.argumentStringArrayList(key: String) = lazy { arguments?.getStringArrayList(key)!! }

fun <T : Parcelable> Fragment.nullableArgumentParcelable(key: String) = lazy { arguments?.getParcelable<T>(key) }
fun <T : Parcelable> Fragment.nullableArgumentParcelableArrayList(key: String) = lazy { arguments?.getParcelableArrayList<T>(key) }
fun Fragment.nullableArgumentBoolean(key: String, defaultValue: Boolean = false) = lazy { arguments?.getBoolean(key, defaultValue) }
fun Fragment.nullableArgumentInt(key: String, defaultValue: Int = 0) = lazy { arguments?.getInt(key, defaultValue) }
fun Fragment.nullableArgumentLong(key: String, defaultValue: Long = 0L) = lazy { arguments?.getLong(key, defaultValue) }
fun Fragment.nullableArgumentShort(key: String, defaultValue: Short = 0) = lazy { arguments?.getShort(key, defaultValue) }
fun Fragment.nullableArgumentChar(key: String, defaultValue: Char = ' ') = lazy { arguments?.getChar(key, defaultValue) }
fun Fragment.nullableArgumentByte(key: String, defaultValue: Byte = 0) = lazy { arguments?.getByte(key, defaultValue) }
fun Fragment.nullableArgumentFloat(key: String, defaultValue: Float = 0f) = lazy { arguments?.getFloat(key, defaultValue) }
fun Fragment.nullableArgumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { arguments?.getDouble(key, defaultValue) }
fun Fragment.nullableArgumentCharSequence(key: String, defaultValue: CharSequence = "") = lazy { arguments?.getCharSequence(key, defaultValue) }
fun Fragment.nullableArgumentString(key: String, defaultValue: String = "") = lazy { arguments?.getString(key, defaultValue) }
fun Fragment.nullableArgumentStringArrayList(key: String) = lazy { arguments?.getStringArrayList(key) }

fun <T : Parcelable> Activity.argumentParcelable(key: String) = lazy { intent?.getParcelableExtra<T>(key)!! }
fun Activity.argumentBoolean(key: String, defaultValue: Boolean = false) = lazy { intent?.getBooleanExtra(key, defaultValue)!! }
fun Activity.argumentInt(key: String, defaultValue: Int = 0) = lazy { intent?.getIntExtra(key, defaultValue)!! }
fun Activity.argumentLong(key: String, defaultValue: Long = 0L) = lazy { intent?.getLongExtra(key, defaultValue)!! }
fun Activity.argumentShort(key: String, defaultValue: Short = 0) = lazy { intent?.getShortExtra(key, defaultValue)!! }
fun Activity.argumentChar(key: String, defaultValue: Char = ' ') = lazy { intent?.getCharExtra(key, defaultValue)!! }
fun Activity.argumentByte(key: String, defaultValue: Byte = 0) = lazy { intent?.getByteExtra(key, defaultValue)!! }
fun Activity.argumentFloat(key: String, defaultValue: Float = 0f) = lazy { intent?.getFloatExtra(key, defaultValue)!! }
fun Activity.argumentDouble(key: String, defaultValue: Double = 0.toDouble()) = lazy { intent?.getDoubleExtra(key, defaultValue)!! }
fun Activity.argumentCharSequence(key: String) = lazy { intent?.getCharSequenceExtra(key)!! }
fun Activity.argumentString(key: String) = lazy { intent?.getStringExtra(key)!! }

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