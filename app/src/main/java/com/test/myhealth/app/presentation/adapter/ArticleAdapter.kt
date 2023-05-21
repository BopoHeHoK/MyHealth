package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.myhealth.databinding.ItemArticleBinding
import com.test.myhealth.domain.model.Article

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)

    private var articleList = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        Glide.with(holder.itemView).load("http://192.168.1.51:5000/${articleList[position].img}")
            .into(holder.binding.illustration)
        holder.binding.apply {
            title.text = articleList[position].title
            content.text = articleList[position].content
            likes.text = articleList[position].likes.toString()
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setArticleList(articleList: List<Article>) {
        this.articleList = articleList as ArrayList<Article>
        notifyDataSetChanged()
    }
}