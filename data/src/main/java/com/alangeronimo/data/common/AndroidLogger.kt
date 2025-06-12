package com.alangeronimo.data.common

import android.util.Log

class AndroidLogger : MyLogger {
    override fun logError(tag: String, message: String, throwable: Throwable?) {
        Log.e(tag, message, throwable)
    }
}