package com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.item_news_small.view.*

class NewsSmallViewHolder(itemView: View,delegate:NewsItemDelegate)
    : BaseViewHolder(itemView) {
    override fun bindData(data: NewsVO) {
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.iv_small_image)

        itemView.tv_news_header_small.text=data.title
        itemView.tv_published_date_small.text=data.publication?.postedTime

    }


    init {
        itemView.setOnClickListener {
            delegate.onTapNewsDetail(dataId = itemView.id.toString())
        }
    }

}