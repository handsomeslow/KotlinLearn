package com.jun.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {

    val items = listOf(
            "给初学者的RxJava2.0教程（七）: Flowable",
            "Android之View的诞生之谜",
            "Android之自定义View的死亡三部曲之Measure",
            "Using ThreadPoolExecutor in Android ",
            "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
            "Android异步的姿势，你真的用对了吗？",
            "Android 高质量录音库。",
            "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        loadList()
    }


    private fun loadList() = doAsync {
        val result = getLinks("http://gank.io/")
        uiThread {
            recyclerView.adapter = MainAdapter(result)
        }
    }

    private fun getLinks(url :String): ArrayList<String>{
        val links = ArrayList<String>()
        val doc: Document = Jsoup.connect(url).get()
        val elements: Elements = doc.select("div.outlink").first().allElements
        for (e in elements) {
            //links.add("11"+e.attr("href"))
            links.add(e.text())
        }
        return links
    }

}
