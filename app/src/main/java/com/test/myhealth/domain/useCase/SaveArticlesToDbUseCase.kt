package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Article

class SaveArticlesToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(article: Article) {
        return userRepository.saveArticlesToDb(article = article)
    }
}