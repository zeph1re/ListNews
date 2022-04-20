package binar.ganda.listnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.ganda.listnews.R
import binar.ganda.listnews.model.ResponseDataNewsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var dataNews : List<ResponseDataNewsItem>? = null

    fun setDataNews(news : List<ResponseDataNewsItem>) {
        this.dataNews = news
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val tampilan = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(tampilan)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.tvJudulNews.text = dataNews!![position].title
        holder.itemView.tvTglNews.text = dataNews!![position].createdAt
        holder.itemView.tvAuthor.text = dataNews!![position].author

        Glide.with(holder.itemView.context).load(dataNews!![position].image).into(holder.itemView.img_news)

    }

    override fun getItemCount(): Int {
        if (dataNews == null) {
            return 0
        } else {
            return dataNews!!.size
        }
    }

}