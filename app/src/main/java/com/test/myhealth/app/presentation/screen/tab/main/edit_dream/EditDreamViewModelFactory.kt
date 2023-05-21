package com.test.myhealth.app.presentation.screen.tab.main.edit_dream

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class EditDreamViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getDreamFromDbByUserIdUseCase: GetDreamFromDbByUserIdUseCase,
    private val getDreamInfoFromDbByDreamIdUseCaseFactory: GetDreamInfoFromDbByDreamIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditDreamViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getDreamFromDbByUserIdUseCase = getDreamFromDbByUserIdUseCase,
            getDreamInfoFromDbByDreamIdUseCaseFactory = getDreamInfoFromDbByDreamIdUseCaseFactory,
        ) as T
    }
}