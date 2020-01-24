package bug.capitulated.core_common.util

import android.os.Build

fun is26orMore() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

fun is28orMore() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P