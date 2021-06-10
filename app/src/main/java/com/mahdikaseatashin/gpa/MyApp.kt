package com.mahdikaseatashin.gpa

import android.app.Application
import com.mahdikaseatashin.gpa.api.networkModule
import com.mahdikaseatashin.gpa.repository.mainRepositoryModule
import com.mahdikaseatashin.gpa.ui.activityModule
import com.mahdikaseatashin.gpa.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        print("hi")

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    activityModule,
                    viewModelModule,
                    networkModule,
                    mainRepositoryModule
                )
            )
        }
    }
}
