package com.test.myhealth.app.presentation.screen.tab.profile.menu.biometrics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class BiometricsViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    private val saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BiometricsViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
            saveUserParameterToDbUseCase = saveUserParameterToDbUseCase,
        ) as T
    }
}