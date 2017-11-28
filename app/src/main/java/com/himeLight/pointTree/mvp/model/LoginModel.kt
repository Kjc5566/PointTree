package com.himeLight.pointTree.mvp.model

import android.app.Application

import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope

import javax.inject.Inject

import com.himeLight.pointTree.mvp.contract.LoginContract


@ActivityScope
class LoginModel @Inject
constructor(repositoryManager: IRepositoryManager, private var mGson: Gson?, private var mApplication: Application?) : BaseModel(repositoryManager), LoginContract.Model {

    override fun onDestroy() {
        super.onDestroy()
        this.mGson = null
        this.mApplication = null
    }

}