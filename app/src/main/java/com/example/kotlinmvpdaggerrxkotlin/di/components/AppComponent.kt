package com.example.kotlinmvpdaggerrxkotlin.di.components

import com.example.kotlinmvpdaggerrxkotlin.GithubApp
import com.example.kotlinmvpdaggerrxkotlin.di.modules.AppModule
import com.example.kotlinmvpdaggerrxkotlin.di.modules.NetworkModule
import com.example.kotlinmvpdaggerrxkotlin.di.modules.PresenterModule
import com.example.kotlinmvpdaggerrxkotlin.ui.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, PresenterModule::class))
interface AppComponent {
    fun inject(app: GithubApp)
    fun inject(mainFragment: MainFragment)
}