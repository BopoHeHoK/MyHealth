package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Medicine

class GetMedicineFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): Medicine {
        return userRepository.getMedicineFromDb(userId = userId)
    }
}