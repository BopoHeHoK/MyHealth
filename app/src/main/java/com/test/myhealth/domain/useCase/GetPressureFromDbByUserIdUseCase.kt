package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Pressure

class GetPressureFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): Pressure {
        return userRepository.getPressureFromDb(userId = userId)
    }
}