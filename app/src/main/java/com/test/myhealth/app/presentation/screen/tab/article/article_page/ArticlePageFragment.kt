package com.test.myhealth.app.presentation.screen.tab.article.article_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
    }
}