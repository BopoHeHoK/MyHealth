package com.test.myhealth.app.presentation.screen.tab.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myhealth.domain.model.*
import com.test.myhealth.domain.useCase.*
import kotlinx.coroutines.launch

class ScheduleViewModel(
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
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun observerWater(userId: Long): Water {
        return getWaterFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerFood(userId: Long): Food {
        return getFoodFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerMedicine(userId: Long): Medicine {
        return getMedicineFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerMedicineInfo(medicineId: Long): List<MedicineInfo> {
        return getMedicineInfoFromDbByMedicineIdUseCase.execute(medicineId = medicineId)
    }

    fun observerWeight(userId: Long): Weight {
        return getWeightFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun observerPressure(userId: Long): Pressure {
        return getPressureFromDbByUserIdUseCase.execute(userId = userId)
    }

    fun upsertWater(water: Water) {
        viewModelScope.launch {
            saveWaterToDbUseCase.execute(water = water)
        }
    }

    fun upsertFood(food: Food) {
        viewModelScope.launch {
            saveFoodToDbUseCase.execute(food = food)
        }
    }

    fun upsertMedicine(medicine: Medicine) {
        viewModelScope.launch {
            saveMedicineToDbUseCase.execute(medicine = medicine)
        }
    }

    fun upsertMedicineInfo(medicineInfo: MedicineInfo) {
        viewModelScope.launch {
            saveMedicineInfoToDbUseCase.execute(medicineInfo = medicineInfo)
        }

    }

    fun upsertWeight(weight: Weight) {
        viewModelScope.launch {
            saveWeightToDbUseCase.execute(weight = weight)
        }
    }

    fun upsertPressure(pressure: Pressure) {
        viewModelScope.launch {
            savePressureToDbUseCase.execute(pressure = pressure)
        }
    }
}