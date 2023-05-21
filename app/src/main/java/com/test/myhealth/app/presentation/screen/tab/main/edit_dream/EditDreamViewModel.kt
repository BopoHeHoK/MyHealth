package com.test.myhealth.app.presentation.screen.tab.main.edit_dream

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.Dream
import com.test.myhealth.domain.model.DreamInfo
import com.test.myhealth.domain.useCase.GetDreamFromDbByUserIdUseCase
import com.test.myhealth.domain.useCase.GetDreamInfoFromDbByDreamIdUseCase
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase

class EditDreamViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getDreamFromDbByUserIdUseCase: GetDreamFromDbByUserIdUseCase,
    private val getDreamInfoFromDbByDreamIdUseCaseFactory: GetDreamInfoFromDbByDreamIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerDream(userId: Long): List<Dream> {
        return getDreamFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerDreamInfo(dreamId: Long): List<DreamInfo> {
        return getDreamInfoFromDbByDreamIdUseCaseFactory.execute(dreamId = dreamId)
    }
}