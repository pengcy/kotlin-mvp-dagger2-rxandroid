package com.example.kotlinmvpdaggerrxkotlin.ui

interface MainScreenPresenter {
    fun setView(view: MainScreenView)

    fun geGithubAccountInfo(username: String)

    fun clearTasks()
}