package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Gender

class SaveGenderToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(gender: Gender) {
        userRepository.saveGendersToDB(gender = gender)
    }
}