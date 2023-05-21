package com.test.myhealth.app.presentation.screen.tab.article

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.Article
import com.test.myhealth.domain.useCase.GetArticlesFromDbUseCase

class ArticleViewModel(
    private val getArticlesFromDbUseCase: GetArticlesFromDbUseCase,
) : ViewModel() {

    fun observerArticles(): List<Article> {
        return getArticlesFromDbUseCase.execute()
    }
}