package com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseNewsViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null

    abstract fun bindData(data : T)
}