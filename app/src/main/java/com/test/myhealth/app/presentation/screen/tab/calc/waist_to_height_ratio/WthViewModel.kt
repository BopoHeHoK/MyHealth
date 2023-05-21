package com.test.myhealth.app.presentation.screen.tab.calc.waist_to_height_ratio

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.UserParameter
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.GetUserParameterFromDbByUserIdUseCase

class WthViewModel(
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