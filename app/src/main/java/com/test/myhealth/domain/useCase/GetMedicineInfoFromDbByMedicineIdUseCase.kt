package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MedicineInfo

class GetMedicineInfoFromDbByMedicineIdUseCase(private val userRepository: UserRepository) {

    fun execute(medicineId: Long): List<MedicineInfo> {
        return userRepository.getMedicineInfoFromDb(medicineId = medicineId)
    }
}