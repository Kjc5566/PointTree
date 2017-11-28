package com.himeLight.pointTree.di.component

import com.himeLight.pointTree.di.module.MainModule
import com.himeLight.pointTree.mvp.ui.activity.MainActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}