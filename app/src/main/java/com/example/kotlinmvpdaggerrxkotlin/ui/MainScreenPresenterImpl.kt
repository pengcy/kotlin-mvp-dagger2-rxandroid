package com.example.kotlinmvpdaggerrxkotlin.ui

import com.example.kotlinmvpdaggerrxkotlin.data.model.GithubAccount
import com.example.kotlinmvpdaggerrxkotlin.data.network.GithubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


class MainScreenPresenterImpl(githubApi: GithubApi) : MainScreenPresenter {
    private var view: MainScreenView? = null
    var githubApi: GithubApi

    private val compositeDisposable = CompositeDisposable()

    init {
        this.githubApi = githubApi
    }

    override fun setView(view: MainScreenView) {
        this.view = view
    }

    override fun geGithubAccountInfo(username: String) {
        view!!.showProgressBar()

        val disposable = githubApi.getGithubAccountObservable(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Response<GithubAccount>>() {
                    override fun onNext(response : Response<GithubAccount>?) {
                        view!!.showAccountInfo(response!!.body())
                        view!!.hideProgressBar()
                    }

                    override fun onError(e: Throwable?) {
                        e!!.printStackTrace()
                        view!!.showError(e.toString())
                        view!!.hideProgressBar()
                    }

                    override fun onComplete() {
                    }
                })

        compositeDisposable.add(disposable)
    }

    override fun clearTasks() {
        compositeDisposable.clear()
    }
}