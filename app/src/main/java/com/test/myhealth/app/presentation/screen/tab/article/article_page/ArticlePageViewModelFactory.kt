package com.test.myhealth.app.presentation.screen.tab.article.article_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.GetArticleFromDbByArticleIdUseCase
import com.test.myhealth.domain.useCase.GetArticleIdFromSharedPrefsUseCase

class ArticlePageViewModelFactory(
    private val getArticleIdFromSharedPrefsUseCase: GetArticleIdFromSharedPrefsUseCase,
    private val getArticleFromDbByArticleIdUseCase: GetArticleFromDbByArticleIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticlePageViewModel(
            getArticleIdFromSharedPrefsUseCase = getArticleIdFromSharedPrefsUseCase,
            getArticleFromDbByArticleIdUseCase = getArticleFromDbByArticleIdUseCase,
        ) as T
    }
}