package com.himeLight.pointTree.utils

import android.support.design.widget.TabLayout
import android.view.View
import android.view.ViewGroup

/**
 * Created by Samuel on 2017/11/28.
 */

class PointTreeUtils private constructor() {

    init {
        throw IllegalStateException("you can't instantiate me!")
    }

    companion object {

        fun reduceMarginsInTabs(tabLayout: TabLayout, marginOffset: Int) {

            val tabStrip = tabLayout.getChildAt(0)
            if (tabStrip is ViewGroup) {
                for (i in 0 until tabStrip.childCount) {
                    val tabView = tabStrip.getChildAt(i)
                    if (tabView.layoutParams is ViewGroup.MarginLayoutParams) {
                        (tabView.layoutParams as ViewGroup.MarginLayoutParams).leftMargin = marginOffset
                        (tabView.layoutParams as ViewGroup.MarginLayoutParams).rightMargin = marginOffset
                    }
                }

                tabLayout.requestLayout()
            }
        }
    }
}
