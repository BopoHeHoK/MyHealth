package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.MedicineInfoTime

class GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase(private val userRepository: UserRepository) {

    fun execute(medicineInfoId: Long): List<MedicineInfoTime> {
        return userRepository.getMedicineInfoTimesFromDb(medicineInfoId = medicineInfoId)
    }
}