package com.padcmyanmar.padcx.revisionrecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.revisionrecyclerview.R
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders.BaseViewHolder
import com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders.NewsSmallViewHolder
import com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders.NewsViewHolder

class NewsListAdapter(delegate:NewsItemDelegate) : BaseAdapter<BaseViewHolder,NewsVO>() {

    val mDelegate=delegate
    private val VIEW_TYPE_LARGE=2244
    private val VIEW_TYPE_SMALL=1122
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType){
            VIEW_TYPE_LARGE -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
                return NewsViewHolder(view,mDelegate)
            }
            VIEW_TYPE_SMALL -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news_small,parent,false)
                return NewsSmallViewHolder(view,mDelegate)
            }
            else -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
                return NewsViewHolder(view,mDelegate)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        when {
            position % 3 == 0 -> return VIEW_TYPE_LARGE
            else -> return VIEW_TYPE_SMALL

        }

    }
}