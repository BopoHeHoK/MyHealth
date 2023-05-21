package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Article

class GetArticlesFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Article> {
        return userRepository.getArticlesFromDb()
    }
}