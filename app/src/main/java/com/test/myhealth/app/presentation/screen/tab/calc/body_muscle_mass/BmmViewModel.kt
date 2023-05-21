package com.test.myhealth.app.presentation.screen.tab.calc.body_muscle_mass

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.UserParameter
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.GetUserParameterFromDbByUserIdUseCase

class BmmViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerUserParameter(userId: Long): UserParameter {
        return getUserParameterFromDbByUserIdUseCase.execute(userId = userId)
    }
}