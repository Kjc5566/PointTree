package com.himeLight.pointTree.di.component

import com.jess.arms.di.scope.ActivityScope

import dagger.Component

import com.jess.arms.di.component.AppComponent

import com.himeLight.pointTree.di.module.CollectPointModule

import com.himeLight.pointTree.mvp.ui.fragment.CollectPointFragment

@ActivityScope
@Component(modules = arrayOf(CollectPointModule::class), dependencies = arrayOf(AppComponent::class))
interface CollectPointComponent {
    fun inject(fragment: CollectPointFragment)
}