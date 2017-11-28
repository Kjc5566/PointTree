package com.himeLight.pointTree.mvp.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridView
import android.widget.RelativeLayout

import com.himeLight.pointTree.R
import com.himeLight.pointTree.mvp.ui.adapter.KeyBoardAdapter

import java.util.ArrayList
import java.util.HashMap

/**
 * 虚拟键盘
 */
class VirtualKeyboardView @JvmOverloads constructor(internal var context: Context, attrs: AttributeSet? = null) : RelativeLayout(context, attrs) {

    //因为就6个输入框不会变了，用数组内存申请固定空间，比List省空间（自己认为）
    val gridView: GridView    //用GrideView布局键盘，其实并不是真正的键盘，只是模拟键盘的功能

    val valueList: ArrayList<Map<String, String>>    //有人可能有疑问，为何这里不用数组了？
    //因为要用Adapter中适配，用数组不能往adapter中填充

//    val layoutBack: RelativeLayout

    init {

        val view = View.inflate(context, R.layout.layout_virtual_keyboard, null)

        valueList = ArrayList()

//        layoutBack = view.findViewById<View>(R.id.layoutBack) as RelativeLayout

        gridView = view.findViewById<View>(R.id.gv_keyboard) as GridView

        initValueList()

        setupView()

        addView(view)      //必须要，不然不显示控件
    }

    private fun initValueList() {

        // 初始化按钮上应该显示的数字
        for (i in 1..12) {
            val map = HashMap<String, String>()
            when {
                i < 10 -> map.put("name", i.toString())
                i == 10 -> map.put("name", "")
                i == 11 -> map.put("name", 0.toString())
                i == 12 -> map.put("name", "OK")
            }
            valueList.add(map)
        }
    }

    private fun setupView() {

        val keyBoardAdapter = KeyBoardAdapter(context, valueList)
        gridView.adapter = keyBoardAdapter
    }
}
