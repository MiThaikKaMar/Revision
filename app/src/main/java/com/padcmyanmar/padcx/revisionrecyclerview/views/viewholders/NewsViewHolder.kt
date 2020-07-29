package com.padcmyanmar.padcx.revisionrecyclerview.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(itemView : View,delegate : NewsItemDelegate):BaseViewHolder(itemView) {
    override fun bindData(data: NewsVO) {
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.iv_large_image)

        itemView.tv_publication.text=data.publication?.publicationName
        itemView.tv_news_header.text=data.title
        itemView.tv_published_date.text=data.publication?.postedTime
    }

    init {
        itemView.setOnClickListener {
            delegate.onTapNewsDetail(dataId = itemView.id.toString())

        }
    }
}