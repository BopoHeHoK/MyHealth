package com.test.myhealth.app.presentation.screen.tab.article

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.Article
import com.test.myhealth.domain.useCase.GetArticlesFromDbUseCase
import com.test.myhealth.domain.useCase.SetArticleIdToSharedPrefsUseCase

class ArticleViewModel(
    private val getArticlesFromDbUseCase: GetArticlesFromDbUseCase,
    private val setArticleIdToSharedPrefsUseCase: SetArticleIdToSharedPrefsUseCase,
) : ViewModel() {

    fun observerArticles(): List<Article> {
        return getArticlesFromDbUseCase.execute()
    }

    fun setArticleIdToSharedPrefsUseCase(): SetArticleIdToSharedPrefsUseCase {
        return setArticleIdToSharedPrefsUseCase
    }
}