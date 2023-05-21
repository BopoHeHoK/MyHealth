package com.test.myhealth.app.app

import android.app.Application
import com.test.myhealth.app.di.AppComponent
import com.test.myhealth.app.di.AppModule
import com.test.myhealth.app.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}