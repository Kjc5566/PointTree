package com.himeLight.pointTree.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.himeLight.pointTree.mvp.contract.MainContract
import com.himeLight.pointTree.mvp.model.MainModel

@Module
class MainModule
/**
 * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
 */
(private val view: MainContract.View) {

  @ActivityScope
  @Provides internal fun provideMainView(): MainContract.View {
    return this.view
  }

  @ActivityScope
  @Provides internal fun provideMainModel(model: MainModel): MainContract.Model {
    return model
  }
}