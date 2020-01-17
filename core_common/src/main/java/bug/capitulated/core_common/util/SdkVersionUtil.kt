package bug.capitulated.core_common.util

import android.os.Build

fun isOreoOrMore() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O // 26

fun isNougatOrMore() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N // 24

fun isMarshmallowOrMore() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M // 23