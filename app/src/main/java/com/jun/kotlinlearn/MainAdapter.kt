package com.jun.kotlinlearn

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view_list_layout.view.*

/**
 * Created by Jun on 2017/6/7.
 */
class MainAdapter(val items : List<News>, val itemClickListener: (News)->Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_list_layout, parent, false)
        return ViewHolder(view,itemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: View, val itemClickListener: (News)->Unit) : RecyclerView.ViewHolder(view) {
        fun bind(news: News) {
            view.title.text = news.title
            view.desc.text = news.desc
            if (news.image.isNotEmpty()) {
                Glide.with(view.context).load(news.image).into(view.image)
                view.image.visibility = View.VISIBLE
            } else{
                view.image.visibility = View.GONE
            }

            view.setOnClickListener {
                itemClickListener(news)
            }
        }
    }
}