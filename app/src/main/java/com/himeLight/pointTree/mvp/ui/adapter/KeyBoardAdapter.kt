package com.himeLight.pointTree.mvp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.himeLight.pointTree.R
import java.util.ArrayList

/**
 * Created by Samuel on 2017/11/26.
 */

class KeyBoardAdapter(private val mContext: Context, private val valueList: ArrayList<Map<String, String>>) : BaseAdapter() {

    override fun getCount(): Int {
        return valueList.size
    }

    override fun getItem(position: Int): Any {
        return valueList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item_virtual_keyboard, null)
            viewHolder = ViewHolder()
            viewHolder.btnKey = convertView!!.findViewById(R.id.btn_keys)
            viewHolder.imgDelete = convertView.findViewById(R.id.imgDelete)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        when (position) {
            11 -> {
                viewHolder.imgDelete!!.visibility = View.INVISIBLE
                viewHolder.btnKey!!.visibility = View.VISIBLE
                viewHolder.btnKey!!.text = valueList[position]["name"]
            }
            9 -> {
//                viewHolder.btnKey!!.setBackgroundResource(R.mipmap.keyboard_delete_img)
                viewHolder.imgDelete!!.visibility = View.VISIBLE
                viewHolder.btnKey!!.text = valueList[position]["name"]
                viewHolder.btnKey!!.visibility = View.VISIBLE
            }
            else -> {
                viewHolder.imgDelete!!.visibility = View.INVISIBLE
                viewHolder.btnKey!!.visibility = View.VISIBLE
                viewHolder.btnKey!!.text = valueList[position]["name"]
            }
        }
        return convertView
    }

    /**
     * 存放控件
     */
    inner class ViewHolder {
        var btnKey: TextView? = null
        var imgDelete: RelativeLayout? = null
    }
}
