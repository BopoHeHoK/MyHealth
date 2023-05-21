package com.test.myhealth.app.presentation.screen.tab.schedule.edit_medicine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class EditMedicineViewModelFactory(
    private val getMedicineInfoTimesFromDbByMedicineInfoIdUseCase: GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditMedicineViewModel(
            getMedicineInfoTimesFromDbByMedicineInfoIdUseCase = getMedicineInfoTimesFromDbByMedicineInfoIdUseCase
        ) as T
    }
}