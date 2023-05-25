package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.model.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserFromDbByIdUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {
        val testId = 1L
        val testUser = User(
            id = 1L,
            email = "test@test.test",
            phoneNumber = "89999999999",
            firstName = "Иван",
            lastName = "Иванов",
            roleId = 1L,
        )
        Mockito.`when`(userRepository.getUserFromDb(id = testId)).thenReturn(testUser)
        val useCase = GetUserFromDbByIdUseCase(userRepository = userRepository)
        val actual = useCase.execute(id = testId)
        val expected = User(
            id = 1L,
            email = "test@test.test",
            phoneNumber = "89999999999",
            firstName = "Иван",
            lastName = "Иванов",
            roleId = 1L,
        )
        Assertions.assertEquals(expected, actual)
    }
}