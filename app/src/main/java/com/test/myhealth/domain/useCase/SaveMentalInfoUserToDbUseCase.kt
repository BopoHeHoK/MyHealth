package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MentalInfo

class SaveMentalInfoUserToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(mentalInfo: MentalInfo) {
        return userRepository.saveMentalInfoToDb(mentalInfo = mentalInfo)
    }
}