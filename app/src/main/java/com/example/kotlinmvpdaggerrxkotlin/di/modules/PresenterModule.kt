package com.example.kotlinmvpdaggerrxkotlin.di.modules

import com.example.kotlinmvpdaggerrxkotlin.data.network.GithubApi
import com.example.kotlinmvpdaggerrxkotlin.ui.MainScreenPresenter
import com.example.kotlinmvpdaggerrxkotlin.ui.MainScreenPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    internal fun provideMainScreenPresenter(githubApi: GithubApi): MainScreenPresenter {
        return MainScreenPresenterImpl(githubApi)
    }
}