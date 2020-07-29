package com.padcmyanmar.padcx.revisionrecyclerview.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.revisionrecyclerview.R
import com.padcmyanmar.padcx.revisionrecyclerview.data.models.NewsModel
import com.padcmyanmar.padcx.revisionrecyclerview.data.models.NewsModelImpl
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.NewsDetailView
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : BaseActivity(),NewsDetailView {

    private val mNewsModelImpl : NewsModel = NewsModelImpl

    companion object{

        const val ID_DATA="data id"
        fun newIntent(context: Context,dataId: String): Intent {
            val intent=Intent(context,NewsDetailActivity::class.java)
            intent.putExtra(ID_DATA,dataId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val newsDataId = intent.getStringExtra(ID_DATA)
        val news= mNewsModelImpl.getNewsById(newsDataId)

        Glide.with(this)
            .load(news.heroImage)
            .into(iv_news_detail)

        tv_detail_description.text=news.description
    }
}


