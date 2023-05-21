package com.test.myhealth.app.presentation.screen.tab.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class ArticleViewModelFactory(
    private val getArticlesFromDbUseCase: GetArticlesFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(
            getArticlesFromDbUseCase = getArticlesFromDbUseCase,
        ) as T
    }
}