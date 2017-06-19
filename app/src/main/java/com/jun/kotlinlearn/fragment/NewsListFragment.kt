package com.jun.kotlinlearn.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jun.kotlinlearn.activity.WebActivity
import com.jun.kotlinlearn.adapter.MainAdapter
import com.jun.kotlinlearn.entity.News
import kotlinx.android.synthetic.main.fragment_news_list_layout.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup
import com.jun.kotlinlearn.R
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    companion object {
        fun newInstance() : NewsListFragment {
            val fragment = NewsListFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_news_list_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        loadList()
    }

    private fun loadList() = doAsync {
        val result = getLinks("http://www.cnbeta.com/")
        uiThread {
            recyclerView.adapter = MainAdapter(result) {
                val url = "http://m.cnbeta.com/view" + it.url.substring(it.url.lastIndexOf("/"))
                val intent = Intent()
                intent.setClass(activity, WebActivity::class.java)
                intent.putExtra("url", url)
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
