package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Dream

class SaveDreamToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(dream: Dream) {
        return userRepository.saveDreamToDb(dream = dream)
    }
}