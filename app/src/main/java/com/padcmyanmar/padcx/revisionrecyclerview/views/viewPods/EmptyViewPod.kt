package com.padcmyanmar.padcx.revisionrecyclerview.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.view.Window
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.empty_view_pod.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setEmptyData(message : String,imageUrl : String){
        tv_empty.text=message

        Glide.with(this)
            .load(imageUrl)
            .into(iv_empty)
    }
}