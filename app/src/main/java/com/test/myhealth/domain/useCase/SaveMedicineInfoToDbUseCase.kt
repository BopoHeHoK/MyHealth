package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MedicineInfo

class SaveMedicineInfoToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(medicineInfo: MedicineInfo) {
        return userRepository.saveMedicineInfoToDb(medicineInfo = medicineInfo)
    }
}