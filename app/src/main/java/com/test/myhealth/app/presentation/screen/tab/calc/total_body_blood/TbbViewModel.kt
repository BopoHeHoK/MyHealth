package com.test.myhealth.app.presentation.screen.tab.calc.total_body_blood

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.UserParameter
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.GetUserParameterFromDbByUserIdUseCase

class TbbViewModel(
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