package com.alangeronimo.saketour.commons

import android.content.Context

fun Context.readBackupJson(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}