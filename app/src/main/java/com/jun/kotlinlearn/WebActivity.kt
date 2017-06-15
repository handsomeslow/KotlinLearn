package com.jun.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_layout.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_layout)
        val url = intent.getStringExtra("url")
        webView.loadUrl(url)
    }
}
