package com.test.myhealth.app.presentation.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.myhealth.R
import com.test.myhealth.app.presentation.screen.tab.article.article_page.ArticlePageFragment
import com.test.myhealth.databinding.ItemArticleBinding
import com.test.myhealth.domain.model.Article
import com.test.myhealth.domain.useCase.SetArticleIdToSharedPrefsUseCase

class ArticleAdapter(
    private val view: View,
    private val setArticleIdToSharedPrefsUseCase: SetArticleIdToSharedPrefsUseCase,
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {



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
        Glide.with(holder.itemView).load("http://192.168.45.130:5000/${articleList[position].img}")
            .into(holder.binding.illustration)
        holder.binding.apply {
            title.text = articleList[position].title
            content.text = articleList[position].content
            likes.text = articleList[position].likes.toString()
            button.setOnClickListener {
                setArticleIdToSharedPrefsUseCase.execute(id = articleList[position].id)
                Navigation.findNavController(view)
                    .navigate(R.id.action_rootFragment_to_articlePageFragment)
            }
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