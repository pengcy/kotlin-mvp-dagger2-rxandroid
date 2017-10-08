package com.example.kotlinmvpdaggerrxkotlin.data.network

import com.example.kotlinmvpdaggerrxkotlin.data.model.GithubAccount
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/users/{username}")
    fun getGithubAccountObservable(@Path("username") username: String): Observable<Response<GithubAccount>>

}