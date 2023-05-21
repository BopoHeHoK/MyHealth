package com.test.myhealth.app.presentation.screen.tab.profile.menu.biometrics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myhealth.domain.model.UserParameter
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.GetUserParameterFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.SaveUserParameterToDbUseCase
import kotlinx.coroutines.launch

class BiometricsViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    private val saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerUserParameter(userId: Long): UserParameter {
        return getUserParameterFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun upsertUserParameter(userParameter: UserParameter) {
        viewModelScope.launch {
            saveUserParameterToDbUseCase.execute(userParameter = userParameter)
        }
    }
}