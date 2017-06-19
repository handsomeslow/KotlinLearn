package com.jun.kotlinlearn.data

import com.google.gson.Gson
import com.jun.kotlinlearn.entity.GankNews
import com.jun.kotlinlearn.entity.GankNewsList

/**
 * Desc
 * Created by Jun on 2017/6/19.
 */
class DataLoader {

    fun getGankNewsList(date:String): List<GankNews> {
        val url = Request.BASE_URL+date
        return Gson().fromJson(Request(url).run(),GankNewsList::class.java).results
    }
}