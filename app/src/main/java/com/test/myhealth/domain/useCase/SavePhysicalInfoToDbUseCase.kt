package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.PhysicalInfo

class SavePhysicalInfoToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(physicalInfo: PhysicalInfo) {
        return userRepository.savePhysicalInfoToDb(physicalInfo = physicalInfo)
    }
}