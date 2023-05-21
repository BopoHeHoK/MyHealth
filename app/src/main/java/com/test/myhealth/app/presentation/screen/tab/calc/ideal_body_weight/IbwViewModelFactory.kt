package com.test.myhealth.app.presentation.screen.tab.calc.ideal_body_weight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.GetUserParameterFromDbByUserIdUseCase

class IbwViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IbwViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        ) as T
    }
}