package com.alangeronimo.saketour

import android.app.Application
import com.alangeronimo.saketour.di.dataModule
import com.alangeronimo.saketour.di.domainModule
import com.alangeronimo.saketour.di.networkModule
import com.alangeronimo.saketour.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MyApp)
            // Load modules
            modules(
                listOf(
                    networkModule,
                    dataModule,
                    presentationModule,
                    domainModule,
                )
            )
        }
    }
}
