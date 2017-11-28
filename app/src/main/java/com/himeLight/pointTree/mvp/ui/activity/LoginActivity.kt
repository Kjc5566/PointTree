package com.himeLight.pointTree.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.himeLight.pointTree.di.component.DaggerLoginComponent
import com.himeLight.pointTree.di.module.LoginModule
import com.himeLight.pointTree.mvp.contract.LoginContract
import com.himeLight.pointTree.mvp.presenter.LoginPresenter

import com.himeLight.pointTree.R


import com.jess.arms.utils.Preconditions.checkNotNull


class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {


  override fun setupActivityComponent(appComponent: AppComponent) {
    DaggerLoginComponent //如找不到该类,请编译一下项目
        .builder()
        .appComponent(appComponent)
        .loginModule(LoginModule(this))
        .build()
        .inject(this)
  }

  override fun initView(savedInstanceState: Bundle): Int {
    return R.layout.activity_login //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
  }

  override fun initData(savedInstanceState: Bundle) {

  }


  override fun showLoading() {

  }

  override fun hideLoading() {

  }

  override fun showMessage(message: String) {
    checkNotNull(message)
    ArmsUtils.snackbarText(message)
  }

  override fun launchActivity(intent: Intent) {
    checkNotNull(intent)
    ArmsUtils.startActivity(intent)
  }

  override fun killMyself() {
    finish()
  }
}
