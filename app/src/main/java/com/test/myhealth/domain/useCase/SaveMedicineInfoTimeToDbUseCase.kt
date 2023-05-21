package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MedicineInfoTime

class SaveMedicineInfoTimeToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(medicineInfoTime: MedicineInfoTime) {
        return userRepository.saveMedicineInfoTimeToDb(medicineInfoTime = medicineInfoTime)
    }
}