package com.test.myhealth.app.presentation.screen.tab.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.domain.useCase.*

class ScheduleViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getWaterFromDbByUserIdUseCase: GetWaterFromDbByUserIdUseCase,
    private val getFoodFromDbByUserIdUseCase: GetFoodFromDbByUserIdUseCase,
    private val getMedicineFromDbByUserIdUseCase: GetMedicineFromDbByUserIdUseCase,
    private val getMedicineInfoFromDbByMedicineIdUseCase: GetMedicineInfoFromDbByMedicineIdUseCase,
    private val getWeightFromDbByUserIdUseCase: GetWeightFromDbByUserIdUseCase,
    private val getPressureFromDbByUserIdUseCase: GetPressureFromDbByUserIdUseCase,
    private val saveWaterToDbUseCase: SaveWaterToDbUseCase,
    private val saveFoodToDbUseCase: SaveFoodToDbUseCase,
    private val saveMedicineToDbUseCase: SaveMedicineToDbUseCase,
    private val saveMedicineInfoToDbUseCase: SaveMedicineInfoToDbUseCase,
    private val saveWeightToDbUseCase: SaveWeightToDbUseCase,
    private val savePressureToDbUseCase: SavePressureToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ScheduleViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getWaterFromDbByUserIdUseCase = getWaterFromDbByUserIdUseCase,
            getFoodFromDbByUserIdUseCase = getFoodFromDbByUserIdUseCase,
            getMedicineFromDbByUserIdUseCase = getMedicineFromDbByUserIdUseCase,
            getMedicineInfoFromDbByMedicineIdUseCase = getMedicineInfoFromDbByMedicineIdUseCase,
            getWeightFromDbByUserIdUseCase = getWeightFromDbByUserIdUseCase,
            getPressureFromDbByUserIdUseCase = getPressureFromDbByUserIdUseCase,
            saveWaterToDbUseCase = saveWaterToDbUseCase,
            saveFoodToDbUseCase = saveFoodToDbUseCase,
            saveMedicineToDbUseCase = saveMedicineToDbUseCase,
            saveMedicineInfoToDbUseCase = saveMedicineInfoToDbUseCase,
            saveWeightToDbUseCase = saveWeightToDbUseCase,
            savePressureToDbUseCase = savePressureToDbUseCase,
        ) as T
    }
}