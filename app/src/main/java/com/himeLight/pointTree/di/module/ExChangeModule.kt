package com.himeLight.pointTree.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.himeLight.pointTree.mvp.contract.ExChangeContract
import com.himeLight.pointTree.mvp.model.ExChangeModel


@Module
class ExChangeModule
/**
 * 构建ExChangeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
 */
(private val view: ExChangeContract.View) {

    @ActivityScope
    @Provides
    internal fun provideExChangeView(): ExChangeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideExChangeModel(model: ExChangeModel): ExChangeContract.Model {
        return model
    }
}