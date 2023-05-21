package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Medicine

class SaveMedicineToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(medicine: Medicine) {
        return userRepository.saveMedicineToDb(medicine = medicine)
    }
}