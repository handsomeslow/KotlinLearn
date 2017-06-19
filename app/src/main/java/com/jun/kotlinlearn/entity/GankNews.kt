package com.jun.kotlinlearn.entity

/**
 * Desc Gank.io
 * Created by Jun on 2017/6/19.
 */
data class GankNews(val _id: String,
                    val createdAt: String,
                    val desc: String,
                    val publishedAt: String,
                    val type: String,
                    val url: String,
                    val used: Boolean,
                    val who: String)