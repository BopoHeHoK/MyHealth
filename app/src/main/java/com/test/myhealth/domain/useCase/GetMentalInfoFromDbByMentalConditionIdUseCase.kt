package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MentalInfo

class GetMentalInfoFromDbByMentalConditionIdUseCase(private val userRepository: UserRepository) {

    fun execute(mentalConditionId: Long): List<MentalInfo> {
        return userRepository.getMentalInfoFromDb(mentalConditionId = mentalConditionId)
    }
}