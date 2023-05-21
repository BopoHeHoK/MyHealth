package com.test.myhealth.app.presentation.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class SingInViewModelFactory(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SingInViewModel(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase
        ) as T
    }
}