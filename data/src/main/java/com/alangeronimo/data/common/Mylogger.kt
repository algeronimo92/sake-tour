package com.alangeronimo.data.common

interface MyLogger {
    fun logError(tag: String, message: String, throwable: Throwable? = null)
}
