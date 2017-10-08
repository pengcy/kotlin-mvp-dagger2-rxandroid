package com.example.kotlinmvpdaggerrxkotlin

import android.app.Application
import com.example.kotlinmvpdaggerrxkotlin.di.components.AppComponent
import com.example.kotlinmvpdaggerrxkotlin.di.components.DaggerAppComponent
import com.example.kotlinmvpdaggerrxkotlin.di.modules.AppModule

class GithubApp : Application() {

    lateinit var appComponent: AppComponent
        protected set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    companion object {
        var instance: GithubApp? = null
            private set
    }
}

