package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Article

class GetArticleFromDbByArticleIdUseCase(private val userRepository: UserRepository) {

    fun execute(articleId: Long): Article {
        return userRepository.getArticleFromDbByArticleId(articleId = articleId)
    }
}