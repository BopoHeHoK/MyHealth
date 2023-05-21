package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Rating

class SaveRatingToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(rating: Rating) {
        return userRepository.saveRatingToDb(rating = rating)
    }
}