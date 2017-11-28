package com.himeLight.pointTree.mvp.presenter

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader

import me.jessyan.rxerrorhandler.core.RxErrorHandler

import javax.inject.Inject

import com.himeLight.pointTree.mvp.contract.ExChangeContract


@ActivityScope
class ExChangePresenter @Inject
constructor(model: ExChangeContract.Model, rootView: ExChangeContract.View, private var mErrorHandler: RxErrorHandler?, private var mApplication: Application?, private var mImageLoader: ImageLoader?, private var mAppManager: AppManager?) : BasePresenter<ExChangeContract.Model, ExChangeContract.View>(model, rootView) {

    override fun onDestroy() {
        super.onDestroy()
        this.mErrorHandler = null
        this.mAppManager = null
        this.mImageLoader = null
        this.mApplication = null
    }

}
