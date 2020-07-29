package com.padcmyanmar.padcx.revisionrecyclerview.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders.BaseNewsViewHolder


abstract class BaseAdapter<T: BaseNewsViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setNewData(data : MutableList<W>){
        mData=data
        notifyDataSetChanged()
    }

    fun appendNewData(data: List<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}