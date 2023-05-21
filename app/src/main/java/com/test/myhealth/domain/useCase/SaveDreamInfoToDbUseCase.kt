package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.DreamInfo

class SaveDreamInfoToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(dreamInfo: DreamInfo) {
        return userRepository.saveDreamInfoToDb(dreamInfo = dreamInfo)
    }
}