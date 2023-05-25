package com.test.myhealth.app.presentation.screen.tab.profile.menu.user_setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myhealth.domain.model.User
import com.test.myhealth.domain.useCase.GetUserFromDbByIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.SaveUserToDbUseCase
import kotlinx.coroutines.launch

class UserSetupViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerUser(id: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = id)
    }

    fun upsertUser(user: User) {
        viewModelScope.launch {
            saveUserToDbUseCase.execute(user = user)
        }
    }
}