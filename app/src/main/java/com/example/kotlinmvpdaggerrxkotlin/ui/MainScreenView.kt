package com.example.kotlinmvpdaggerrxkotlin.ui

import com.example.kotlinmvpdaggerrxkotlin.data.model.GithubAccount


interface MainScreenView {

    fun showAccountInfo(githubAccount: GithubAccount?)

    fun showError(errorType: String)

    fun showProgressBar()

    fun hideProgressBar()

}