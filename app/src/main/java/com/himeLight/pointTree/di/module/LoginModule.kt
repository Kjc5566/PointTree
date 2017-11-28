package com.himeLight.pointTree.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.himeLight.pointTree.mvp.contract.LoginContract
import com.himeLight.pointTree.mvp.model.LoginModel


@Module
class LoginModule
/**
 * 构建LoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
 */
(private val view: LoginContract.View) {

    @ActivityScope
    @Provides
    internal fun provideLoginView(): LoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideLoginModel(model: LoginModel): LoginContract.Model {
        return model
    }
}