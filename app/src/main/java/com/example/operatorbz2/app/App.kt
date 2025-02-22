package com.example.operatorbz2.app

import android.app.Application
import com.example.operatorbz2.di.AppComponent
import com.example.operatorbz2.di.DaggerAppComponent

class App : Application() {

    private val appComponent = DaggerAppComponent.factory().create(this)


    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}