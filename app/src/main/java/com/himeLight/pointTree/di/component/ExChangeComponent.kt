package com.himeLight.pointTree.di.component

import com.jess.arms.di.scope.ActivityScope

import dagger.Component

import com.jess.arms.di.component.AppComponent

import com.himeLight.pointTree.di.module.ExChangeModule

import com.himeLight.pointTree.mvp.ui.fragment.ExChangeFragment

@ActivityScope
@Component(modules = arrayOf(ExChangeModule::class), dependencies = arrayOf(AppComponent::class))
interface ExChangeComponent {
    fun inject(fragment: ExChangeFragment)
}