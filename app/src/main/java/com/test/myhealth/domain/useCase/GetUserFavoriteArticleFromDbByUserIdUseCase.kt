package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.UserFavoriteArticle

class GetUserFavoriteArticleFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): UserFavoriteArticle {
        return userRepository.getUserFavoriteArticleFromDb(userId = userId)
    }
}