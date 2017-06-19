package com.jun.kotlinlearn.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jun.kotlinlearn.entity.GankNews
import com.jun.kotlinlearn.R
import kotlinx.android.synthetic.main.item_view_list_layout.view.*

/**
 * Desc
 * Created by Jun on 2017/6/19.
 */
class GankNewsAdapter(val items : List<GankNews>, val itemClickListener: (GankNews)->Unit) : RecyclerView.Adapter<GankNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_list_layout, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: View, val itemClickListener: (GankNews) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(news: GankNews) {
            view.title.text = news.desc
            view.desc.text = news.type
            view.setOnClickListener {
                itemClickListener(news)
            }
        }
    }
}
