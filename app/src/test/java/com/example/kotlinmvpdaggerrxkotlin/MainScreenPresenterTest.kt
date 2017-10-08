package com.example.kotlinmvpdaggerrxkotlin

import com.example.kotlinmvpdaggerrxkotlin.data.model.GithubAccount
import com.example.kotlinmvpdaggerrxkotlin.data.network.GithubApi
import com.example.kotlinmvpdaggerrxkotlin.ui.MainScreenPresenter
import com.example.kotlinmvpdaggerrxkotlin.ui.MainScreenPresenterImpl
import com.example.kotlinmvpdaggerrxkotlin.ui.MainScreenView
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class MainPresenterUnitTest {

    @Mock
    lateinit var githubApi : GithubApi

    @Mock
    lateinit var view: MainScreenView

    @Mock
    lateinit var githubAccount : GithubAccount


    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    lateinit var presenter: MainScreenPresenter
    private val username = "pengcy"

    @Before
    fun setUp() {
        presenter = MainScreenPresenterImpl(githubApi)
        presenter.setView(view)
    }

    @After
    fun tearDown() {
        presenter.clearTasks()
    }

    @Test
    fun fetchGithubAccountInfo() {
        Mockito.`when`(githubApi.getGithubAccountObservable(username)).thenReturn(Observable.just(Response.success(githubAccount)))
        presenter.geGithubAccountInfo(username)
        Mockito.verify(view).showProgressBar()
        Mockito.verify(view).hideProgressBar()
        Mockito.verify(view).showAccountInfo(githubAccount)
    }

}