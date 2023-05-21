package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.UserFavoriteArticle

class SaveUserFavoriteArticleToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(userFavoriteArticle: UserFavoriteArticle) {
        return userRepository.saveUserFavoriteArticleToDb(userFavoriteArticle = userFavoriteArticle)
    }
}