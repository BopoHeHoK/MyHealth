package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Dream

class GetDreamFromDbByUserIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<Dream> {
        return userRepository.getDreamFromDb(userId = userId)
    }
}