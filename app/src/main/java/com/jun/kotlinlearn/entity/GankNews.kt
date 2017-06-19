package com.jun.kotlinlearn.entity

import java.util.*

/**
 * Desc Gank.io
 * Created by Jun on 2017/6/19.
 */
data class GankNews(val _id: String,
                    val createdAt: Date,
                    val desc: String,
                    val publishedAt: Date,
                    val type: String,
                    val url: String,
                    val used: Boolean,
                    val who: String)