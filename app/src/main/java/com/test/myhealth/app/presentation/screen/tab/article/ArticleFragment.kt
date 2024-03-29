package com.test.myhealth.app.presentation.screen.tab.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.app.presentation.adapter.ArticleAdapter
import com.test.myhealth.databinding.FragmentArticlesBinding
import javax.inject.Inject

class ArticleFragment : Fragment() {

    @Inject
    lateinit var articleViewModelFactory: ArticleViewModelFactory

    private lateinit var binding: FragmentArticlesBinding
    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectArticleFragment(
            articleFragment = this
        )
        articleViewModel = ViewModelProvider(
            owner = this,
            factory = articleViewModelFactory
        )[ArticleViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeArticles(view)
        toStatistics(view)
    }

    private fun addArticleAdapter(view: View) {
        articleAdapter = ArticleAdapter(view, articleViewModel.setArticleIdToSharedPrefsUseCase())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            adapter = articleAdapter
        }
    }

    private fun observeArticles(view: View) {
        addArticleAdapter(view)
        articleAdapter.setArticleList(articleViewModel.observerArticles())
    }

    private fun toStatistics(view: View) {
        binding.toCharts.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_statisticsFragment)
        }
    }
}