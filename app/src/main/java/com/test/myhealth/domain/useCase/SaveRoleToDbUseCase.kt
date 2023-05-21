package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.Role

class SaveRoleToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(role: Role) {
        return userRepository.saveRolesToDb(role = role)
    }
}