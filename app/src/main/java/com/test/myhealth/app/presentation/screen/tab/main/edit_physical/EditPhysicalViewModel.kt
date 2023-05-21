package com.test.myhealth.app.presentation.screen.tab.main.edit_physical

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.PhysicalCondition
import com.test.myhealth.domain.model.PhysicalInfo
import com.test.myhealth.domain.useCase.GetPhysicalConditionFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.GetPhysicalInfoFromDbByPhysicalConditionIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase

class EditPhysicalViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getPhysicalConditionFromDbByUserIdUseCase: GetPhysicalConditionFromDbByUserIdUseCase,
    private val getPhysicalInfoFromDbByPhysicalConditionIdUseCase: GetPhysicalInfoFromDbByPhysicalConditionIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerPhysical(userId: Long): List<PhysicalCondition> {
        return getPhysicalConditionFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerPhysicalInfo(physicalConditionId: Long): List<PhysicalInfo> {
        return getPhysicalInfoFromDbByPhysicalConditionIdUseCase.execute(physicalConditionId = physicalConditionId)
    }
}