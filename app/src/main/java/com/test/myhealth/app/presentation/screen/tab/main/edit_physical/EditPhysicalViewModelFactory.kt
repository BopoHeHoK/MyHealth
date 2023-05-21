package com.test.myhealth.app.presentation.screen.tab.main.edit_physical

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.GetPhysicalConditionFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.GetPhysicalInfoFromDbByPhysicalConditionIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase

class EditPhysicalViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getPhysicalConditionFromDbByUserIdUseCase: GetPhysicalConditionFromDbByUserIdUseCase,
    private val getPhysicalInfoFromDbByPhysicalConditionIdUseCase: GetPhysicalInfoFromDbByPhysicalConditionIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditPhysicalViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getPhysicalConditionFromDbByUserIdUseCase = getPhysicalConditionFromDbByUserIdUseCase,
            getPhysicalInfoFromDbByPhysicalConditionIdUseCase = getPhysicalInfoFromDbByPhysicalConditionIdUseCase,
        ) as T
    }
}