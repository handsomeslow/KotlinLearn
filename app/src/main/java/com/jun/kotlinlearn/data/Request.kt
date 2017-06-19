package com.jun.kotlinlearn.data

import com.google.gson.Gson
import com.jun.kotlinlearn.entity.BaseResponse
import java.net.URL

/**
 * Desc
 * Created by Jun on 2017/6/14.
 */
class Request(val url: String) {

    companion object {
        val BASE_URL = "http://gank.io/api/"
    }

    fun run(): String {
        val resultStr = URL(url).readText()
        return resultStr
    }
}

