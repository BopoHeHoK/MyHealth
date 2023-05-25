package com.test.myhealth.app.presentation.screen.tab.article.article_page

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.Article
import com.test.myhealth.domain.useCase.GetArticleFromDbByArticleIdUseCase
import com.test.myhealth.domain.useCase.GetArticleIdFromSharedPrefsUseCase

class ArticlePageViewModel(
    private val getArticleIdFromSharedPrefsUseCase: GetArticleIdFromSharedPrefsUseCase,
    private val getArticleFromDbByArticleIdUseCase: GetArticleFromDbByArticleIdUseCase,
) : ViewModel() {

    fun getArticleId(): Long {
        return getArticleIdFromSharedPrefsUseCase.execute()
    }

    fun observerArticle(articleId: Long): Article {
        return getArticleFromDbByArticleIdUseCase.execute(articleId = articleId)
    }

}