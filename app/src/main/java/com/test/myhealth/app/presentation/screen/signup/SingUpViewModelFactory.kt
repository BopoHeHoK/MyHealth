package com.test.myhealth.app.presentation.screen.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class SingUpViewModelFactory(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SingUpViewModel(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase
        ) as T
    }
}