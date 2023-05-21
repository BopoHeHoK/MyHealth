package com.test.myhealth.app.presentation.screen.tab.main.edit_mental

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.GetMentalConditionFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.GetMentalInfoFromDbByMentalConditionIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase

class EditMentalViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getMentalConditionFromDbByUserIdUseCase: GetMentalConditionFromDbByUserIdUseCase,
    private val getMentalInfoFromDbByMentalConditionIdUseCase: GetMentalInfoFromDbByMentalConditionIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditMentalViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getMentalConditionFromDbByUserIdUseCase = getMentalConditionFromDbByUserIdUseCase,
            getMentalInfoFromDbByMentalConditionIdUseCase = getMentalInfoFromDbByMentalConditionIdUseCase,
        ) as T
    }
}