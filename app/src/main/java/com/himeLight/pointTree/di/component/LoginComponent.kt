package com.himeLight.pointTree.di.component

import com.jess.arms.di.scope.ActivityScope

import dagger.Component

import com.jess.arms.di.component.AppComponent

import com.himeLight.pointTree.di.module.LoginModule

import com.himeLight.pointTree.mvp.ui.activity.LoginActivity

@ActivityScope
@Component(modules = arrayOf(LoginModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
}