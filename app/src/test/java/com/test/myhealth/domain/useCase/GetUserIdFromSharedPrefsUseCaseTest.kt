package com.test.myhealth.domain.useCase

import com.test.myhealth.domain.data.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserIdFromSharedPrefsUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {
        val testId = 1L
        Mockito.`when`(userRepository.getUserIdSharedPreferences()).thenReturn(testId)
        val useCase = GetUserIdFromSharedPrefsUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = 1L
        Assertions.assertEquals(expected, actual)
    }
}