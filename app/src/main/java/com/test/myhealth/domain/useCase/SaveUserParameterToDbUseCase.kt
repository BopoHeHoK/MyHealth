package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.UserParameter

class SaveUserParameterToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(userParameter: UserParameter) {
        return userRepository.saveUserParameterToDb(userParameter = userParameter)
    }
}