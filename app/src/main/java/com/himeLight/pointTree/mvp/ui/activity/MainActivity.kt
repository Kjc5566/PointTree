package com.himeLight.pointTree.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import com.himeLight.pointTree.R
import com.himeLight.pointTree.di.component.DaggerMainComponent
import com.himeLight.pointTree.di.module.MainModule
import com.himeLight.pointTree.mvp.contract.MainContract
import com.himeLight.pointTree.mvp.presenter.MainPresenter
import com.himeLight.pointTree.mvp.ui.fragment.CollectPointFragment
import com.himeLight.pointTree.mvp.ui.fragment.ExChangeFragment
import com.himeLight.pointTree.utils.PointTreeUtils
import com.jess.arms.base.AdapterViewPager
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.jess.arms.utils.Preconditions.checkNotNull
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder().appComponent(appComponent).mainModule(MainModule(this)).build().inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    override fun initData(savedInstanceState: Bundle?) {
        val fragments = ArrayList<Fragment>()
        fragments.add(CollectPointFragment())
        fragments.add(ExChangeFragment())
        val titles = arrayOf("集點", "兌換")
        view_pager.adapter = AdapterViewPager(supportFragmentManager, fragments, titles)
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
        view_pager.offscreenPageLimit = 1
        tab_Layout.setupWithViewPager(view_pager)

        PointTreeUtils.reduceMarginsInTabs(tab_Layout, 450)


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

    override fun initViewPager() {
    }
}
