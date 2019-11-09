package bug.capitulated.core_common.util

import android.util.Log

private const val TAG = "myTag"

val String?.log get() = Log.d(TAG, this)

val Any?.logt get() = "$this. ${Thread.currentThread().name}".log
val Any?.log get() = this.toString().log

val Exception.log get() = Log.e(TAG, "", this)
val Throwable.log get() = Log.e(TAG, "", this)