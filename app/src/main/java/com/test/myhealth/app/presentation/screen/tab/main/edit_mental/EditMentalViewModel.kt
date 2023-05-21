package com.test.myhealth.app.presentation.screen.tab.main.edit_mental

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.MentalCondition
import com.test.myhealth.domain.model.MentalInfo
import com.test.myhealth.domain.useCase.GetMentalConditionFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.GetMentalInfoFromDbByMentalConditionIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase

class EditMentalViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getMentalConditionFromDbByUserIdUseCase: GetMentalConditionFromDbByUserIdUseCase,
    private val getMentalInfoFromDbByMentalConditionIdUseCase: GetMentalInfoFromDbByMentalConditionIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerMental(userId: Long): List<MentalCondition> {
        return getMentalConditionFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerMentalInfo(mentalConditionId: Long): List<MentalInfo> {
        return getMentalInfoFromDbByMentalConditionIdUseCase.execute(mentalConditionId = mentalConditionId)
    }
}