package com.test.myhealth.app.presentation.screen.tab.profile

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.User
import com.test.myhealth.domain.useCase.GetUserFromDbByIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.SetUserIdToSharedPrefsUseCase

class ProfileViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun deleteId() {
        setUserIdToSharedPrefsUseCase.execute(id = 0L)
    }

    fun observerUser(id: Long): User {
        return getUserFromDbByIdUseCase.execute(id = id)
    }
}