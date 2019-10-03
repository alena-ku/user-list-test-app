package com.example.users.mvp.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {
    private val compositeSubscription = CompositeDisposable()

    protected fun unsubscribeOnDestroy(subscription: Disposable) {
        compositeSubscription.add(subscription)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeSubscription.clear()
    }
}