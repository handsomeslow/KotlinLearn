package com.jun.kotlinlearn

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * Desc
 * Created by Jun on 2017/6/14.
 */
public class Request(val url :String) {

    public fun run(){
        var links:MutableList<String> = mutableListOf()
        val doc: Document = Jsoup.connect(url).get()
        val elements : Elements = doc.select("li")
        for (e in elements) {
            links.add(e.attr("href"))
        }
    }
}

