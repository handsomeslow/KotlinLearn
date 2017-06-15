package com.jun.kotlinlearn

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {

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
        val result = getLinks("http://www.cnbeta.com/")
        uiThread {
            recyclerView.adapter = MainAdapter(result) {
                val url = "http://m.cnbeta.com/view"+it.url.substring(it.url.lastIndexOf("/"))
                val intent = Intent()
                intent.setClass(this@MainActivity,WebActivity::class.java)
                intent.putExtra("url",url)
                startActivity(intent)
            }
        }
    }

    private fun getLinks(url :String): ArrayList<News>{
        val links = ArrayList<News>()
        val doc: Document = Jsoup.connect(url).get()
        val elements: Elements = doc.select("div.items-area").first().allElements.first().children()

        for (e in elements) {
            if (e.getElementsByTag("dt").text().isEmpty())
                continue
            links.add(News(e.getElementsByTag("dt").text(),
                    e.getElementsByTag("dd").text(),
                    e.select("a[href]").first().attr("href"),
                    e.select("img[src]").first().attr("src")))
        }
        return links
    }

}
