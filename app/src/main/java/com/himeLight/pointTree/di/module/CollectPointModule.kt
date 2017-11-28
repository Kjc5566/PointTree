package com.himeLight.pointTree.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.himeLight.pointTree.mvp.contract.CollectPointContract
import com.himeLight.pointTree.mvp.model.CollectPointModel


@Module
class CollectPointModule
/**
 * 构建CollectPointModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
 */
(private val view: CollectPointContract.View) {

    @ActivityScope
    @Provides
    internal fun provideCollectPointView(): CollectPointContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    internal fun provideCollectPointModel(model: CollectPointModel): CollectPointContract.Model {
        return model
    }
}