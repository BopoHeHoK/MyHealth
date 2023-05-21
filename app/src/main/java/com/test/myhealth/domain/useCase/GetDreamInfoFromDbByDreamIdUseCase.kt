package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.DreamInfo

class GetDreamInfoFromDbByDreamIdUseCase(private val userRepository: UserRepository) {

    fun execute(dreamId: Long): List<DreamInfo> {
        return userRepository.getDreamInfoFromDb(dreamId = dreamId)
    }
}