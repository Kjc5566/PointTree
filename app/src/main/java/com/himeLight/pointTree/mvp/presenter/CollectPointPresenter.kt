package com.himeLight.pointTree.mvp.presenter

import android.app.Application
import android.text.Editable
import android.text.InputType
import android.view.View
import android.view.WindowManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.EditText
import android.widget.GridView
import com.bumptech.glide.request.transition.Transition
import com.himeLight.pointTree.R

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader

import me.jessyan.rxerrorhandler.core.RxErrorHandler

import javax.inject.Inject

import com.himeLight.pointTree.mvp.contract.CollectPointContract
import com.himeLight.pointTree.mvp.ui.widget.VirtualKeyboardView
import kotlinx.android.synthetic.main.fragment_collectpoint.*
import java.lang.reflect.Method
import java.util.ArrayList


@ActivityScope
class CollectPointPresenter @Inject
constructor(model: CollectPointContract.Model, rootView: CollectPointContract.View, private var mErrorHandler: RxErrorHandler?, private var mApplication: Application?, private var mImageLoader: ImageLoader?, private var mAppManager: AppManager?) : BasePresenter<CollectPointContract.Model, CollectPointContract.View>(model, rootView) {

    private var gridView: GridView? = null

    var valueList: ArrayList<Map<String, String>>? = null

    private var virtualKeyboardView: VirtualKeyboardView? = null

    private var et_phoneNumber: EditText? = null

    override fun onDestroy() {
        super.onDestroy()
        this.mErrorHandler = null
        this.mAppManager = null
        this.mImageLoader = null
        this.mApplication = null
    }

    fun initKeyboard(phone: EditText) {
        et_phoneNumber = phone

        phone.inputType = InputType.TYPE_NULL

        virtualKeyboardView = mAppManager!!.currentActivity.findViewById<VirtualKeyboardView>(R.id.gv_keyboard) as VirtualKeyboardView

        gridView = virtualKeyboardView!!.gridView
        gridView!!.onItemClickListener = onItemClickListener

        valueList = virtualKeyboardView!!.valueList
    }

    private val onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
        if (position < 11 && position != 9) {    //点击0~9按钮
            var amount = et_phoneNumber!!.text.toString().trim()
            amount += valueList!![position]["name"]
            et_phoneNumber!!.setText(amount)

            val ea = et_phoneNumber!!.text as Editable
            et_phoneNumber!!.setSelection(ea.length)
        } else {
            if (position == 11) {
//                var amount = et_phoneNumber!!.text.toString().trim()
//                if (!amount.contains(".")) {
//                    amount += valueList!![position]["name"]
//                    et_phoneNumber!!.setText(amount)
//
//                    val ea = et_phoneNumber!!.text as Editable
//                    et_phoneNumber!!.setSelection(ea.length)
//                }
            }

            if (position == 9) {
                var amount = et_phoneNumber!!.text.toString().trim()
                if (amount.isNotEmpty()) {
                    amount = amount.substring(0, amount.length - 1)
                    et_phoneNumber!!.setText(amount)

                    val ea = et_phoneNumber!!.text as Editable
                    et_phoneNumber!!.setSelection(ea.length)
                }
            }
        }
    }
}
