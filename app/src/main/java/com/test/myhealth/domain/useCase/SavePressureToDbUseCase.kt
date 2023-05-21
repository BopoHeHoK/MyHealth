package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Pressure

class SavePressureToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(pressure: Pressure) {
        return userRepository.savePressureToDb(pressure = pressure)
    }
}