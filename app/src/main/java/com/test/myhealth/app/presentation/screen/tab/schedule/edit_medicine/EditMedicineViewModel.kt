package com.test.myhealth.app.presentation.screen.tab.schedule.edit_medicine

import androidx.lifecycle.ViewModel
import com.test.myhealth.domain.model.MedicineInfoTime
import com.test.myhealth.domain.useCase.GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase

class EditMedicineViewModel(
    private val getMedicineInfoTimesFromDbByMedicineInfoIdUseCase: GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase
) : ViewModel() {

    fun observerMedicineInfoTime(medicineInfoId: Long): List<MedicineInfoTime> {
        return getMedicineInfoTimesFromDbByMedicineInfoIdUseCase.execute(medicineInfoId = medicineInfoId)
    }
}