package com.test.myhealth.app.presentation.screen.tab.article.article_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArticlePageViewModelFactory(
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticlePageFragment(
        ) as T
    }
}