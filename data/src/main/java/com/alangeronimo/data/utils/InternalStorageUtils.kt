package com.alangeronimo.data.utils

import android.content.Context

fun Context.readBackupJson(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}
