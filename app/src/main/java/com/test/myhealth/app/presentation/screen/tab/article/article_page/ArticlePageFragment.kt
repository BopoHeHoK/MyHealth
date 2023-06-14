package com.test.myhealth.app.presentation.screen.tab.article.article_page

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentArticlePageBinding
import javax.inject.Inject

class ArticlePageFragment : Fragment() {

    @Inject
    lateinit var articlePageViewModelFactory: ArticlePageViewModelFactory

    private lateinit var binding: FragmentArticlePageBinding
    private lateinit var articlePageViewModel: ArticlePageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectArticlePageFragment(
            articlePageFragment = this
        )
        articlePageViewModel = ViewModelProvider(
            owner = this,
            factory = articlePageViewModelFactory
        )[ArticlePageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeArticles(view)

    }

    private fun observeArticles(view: View) {
        binding.apply {
            articlePageViewModel.apply {
                val article = observerArticle(getArticleId())
                title.text = article.title
                Glide.with(view.context).load("http://192.168.45.130:5000/${article.img}")
                    .into(illustration)
                content.text = article.content
                likes.text = article.likes.toString()
            }
        }
    }
}