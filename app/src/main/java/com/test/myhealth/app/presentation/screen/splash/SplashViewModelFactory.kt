package com.test.myhealth.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.myhealth.data.storage.converters.ConverterBM
import com.test.myhealth.domain.useCase.*

class SplashViewModelFactory(
    private val converterBM: ConverterBM,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val saveRoleToDbUseCase: SaveRoleToDbUseCase,
    private val saveGenderToDbUseCase: SaveGenderToDbUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
    private val saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
    private val saveRatingToDbUseCase: SaveRatingToDbUseCase,
    private val saveUserFavoriteArticleToDbUseCase: SaveUserFavoriteArticleToDbUseCase,
    private val saveDreamToDbUseCase: SaveDreamToDbUseCase,
    private val saveDreamInfoToDbUseCase: SaveDreamInfoToDbUseCase,
    private val savePhysicalConditionToDbUseCase: SavePhysicalConditionToDbUseCase,
    private val savePhysicalInfoToDbUseCase: SavePhysicalInfoToDbUseCase,
    private val saveMentalConditionToDbUseCase: SaveMentalConditionToDbUseCase,
    private val saveMentalInfoToDbUseCase: SaveMentalInfoUserToDbUseCase,
    private val saveWaterToDbUseCase: SaveWaterToDbUseCase,
    private val saveFoodToDbUseCase: SaveFoodToDbUseCase,
    private val saveMedicineToDbUseCase: SaveMedicineToDbUseCase,
    private val saveMedicineInfoToDbUseCase: SaveMedicineInfoToDbUseCase,
    private val saveMedicineInfoTimeToDbUseCase: SaveMedicineInfoTimeToDbUseCase,
    private val saveWeightToDbUseCase: SaveWeightToDbUseCase,
    private val savePressureToDbUseCase: SavePressureToDbUseCase,
    private val saveArticlesToDbUseCase: SaveArticlesToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(
            converterBM = converterBM,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            saveRoleToDbUseCase = saveRoleToDbUseCase,
            saveGenderToDbUseCase = saveGenderToDbUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
            saveUserParameterToDbUseCase = saveUserParameterToDbUseCase,
            saveRatingToDbUseCase = saveRatingToDbUseCase,
            saveUserFavoriteArticleToDbUseCase = saveUserFavoriteArticleToDbUseCase,
            saveDreamToDbUseCase = saveDreamToDbUseCase,
            saveDreamInfoToDbUseCase = saveDreamInfoToDbUseCase,
            savePhysicalConditionToDbUseCase = savePhysicalConditionToDbUseCase,
            savePhysicalInfoToDbUseCase = savePhysicalInfoToDbUseCase,
            saveMentalConditionToDbUseCase = saveMentalConditionToDbUseCase,
            saveMentalInfoToDbUseCase = saveMentalInfoToDbUseCase,
            saveWaterToDbUseCase = saveWaterToDbUseCase,
            saveFoodToDbUseCase = saveFoodToDbUseCase,
            saveMedicineToDbUseCase = saveMedicineToDbUseCase,
            saveMedicineInfoToDbUseCase = saveMedicineInfoToDbUseCase,
            saveMedicineInfoTimeToDbUseCase = saveMedicineInfoTimeToDbUseCase,
            saveWeightToDbUseCase = saveWeightToDbUseCase,
            savePressureToDbUseCase = savePressureToDbUseCase,
            saveArticlesToDbUseCase = saveArticlesToDbUseCase
        ) as T
    }
}