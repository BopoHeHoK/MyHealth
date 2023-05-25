package com.test.myhealth.app.di

import android.content.Context
import com.test.myhealth.app.presentation.screen.root.RootViewModelFactory
import com.test.myhealth.app.presentation.screen.signin.SingInViewModelFactory
import com.test.myhealth.app.presentation.screen.signup.SingUpViewModelFactory
import com.test.myhealth.app.presentation.screen.splash.SplashViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.article.ArticleViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.article.article_page.ArticlePageViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.article.statistics.StatisticsViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.CalcViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.body_mass_index.BmiViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.body_muscle_mass.BmmViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.ideal_body_weight.IbwViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.total_body_blood.TbbViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.total_body_water.TbwViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.calc.waist_to_height_ratio.WthViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.main.MainViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.main.edit_dream.EditDreamViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.main.edit_mental.EditMentalViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.main.edit_physical.EditPhysicalViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.profile.ProfileViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.profile.menu.biometrics.BiometricsViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.profile.menu.get_premium.GetPremiumViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.profile.menu.user_setup.UserSetupViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.schedule.ScheduleViewModelFactory
import com.test.myhealth.app.presentation.screen.tab.schedule.edit_medicine.EditMedicineViewModelFactory
import com.test.myhealth.data.storage.converters.ConverterBM
import com.test.myhealth.domain.useCase.*
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideRootViewModelFactory(
    ): RootViewModelFactory {
        return RootViewModelFactory(
        )
    }

    @Provides
    fun provideSingInViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase
    ): SingInViewModelFactory {
        return SingInViewModelFactory(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase
        )
    }

    @Provides
    fun provideSingUpViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase
    ): SingUpViewModelFactory {
        return SingUpViewModelFactory(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase
        )
    }

    @Provides
    fun provideSplashViewModelFactory(
        converterBM: ConverterBM,
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        saveRoleToDbUseCase: SaveRoleToDbUseCase,
        saveGenderToDbUseCase: SaveGenderToDbUseCase,
        saveUserToDbUseCase: SaveUserToDbUseCase,
        saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
        saveRatingToDbUseCase: SaveRatingToDbUseCase,
        saveUserFavoriteArticleToDbUseCase: SaveUserFavoriteArticleToDbUseCase,
        saveDreamToDbUseCase: SaveDreamToDbUseCase,
        saveDreamInfoToDbUseCase: SaveDreamInfoToDbUseCase,
        savePhysicalConditionToDbUseCase: SavePhysicalConditionToDbUseCase,
        savePhysicalInfoToDbUseCase: SavePhysicalInfoToDbUseCase,
        saveMentalConditionToDbUseCase: SaveMentalConditionToDbUseCase,
        saveMentalInfoToDbUseCase: SaveMentalInfoUserToDbUseCase,
        saveWaterToDbUseCase: SaveWaterToDbUseCase,
        saveFoodToDbUseCase: SaveFoodToDbUseCase,
        saveMedicineToDbUseCase: SaveMedicineToDbUseCase,
        saveMedicineInfoToDbUseCase: SaveMedicineInfoToDbUseCase,
        saveMedicineInfoTimeToDbUseCase: SaveMedicineInfoTimeToDbUseCase,
        saveWeightToDbUseCase: SaveWeightToDbUseCase,
        savePressureToDbUseCase: SavePressureToDbUseCase,
        saveArticlesToDbUseCase: SaveArticlesToDbUseCase,
    ): SplashViewModelFactory {
        return SplashViewModelFactory(
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
        )
    }

    @Provides
    fun provideArticlePageViewModelFactory(
        getArticleIdFromSharedPrefsUseCase: GetArticleIdFromSharedPrefsUseCase,
        getArticleFromDbByArticleIdUseCase: GetArticleFromDbByArticleIdUseCase,
    ): ArticlePageViewModelFactory {
        return ArticlePageViewModelFactory(
            getArticleIdFromSharedPrefsUseCase = getArticleIdFromSharedPrefsUseCase,
            getArticleFromDbByArticleIdUseCase = getArticleFromDbByArticleIdUseCase,
        )
    }

    @Provides
    fun provideStatisticsViewModelFactory(
    ): StatisticsViewModelFactory {
        return StatisticsViewModelFactory(
        )
    }

    @Provides
    fun provideArticleViewModelFactory(
        getArticlesFromDbUseCase: GetArticlesFromDbUseCase,
        setArticleIdToSharedPrefsUseCase: SetArticleIdToSharedPrefsUseCase,
    ): ArticleViewModelFactory {
        return ArticleViewModelFactory(
            getArticlesFromDbUseCase = getArticlesFromDbUseCase,
            setArticleIdToSharedPrefsUseCase = setArticleIdToSharedPrefsUseCase,
        )
    }

    @Provides
    fun provideBmiViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): BmiViewModelFactory {
        return BmiViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideBmmViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): BmmViewModelFactory {
        return BmmViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideIbwViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): IbwViewModelFactory {
        return IbwViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideTbbViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): TbbViewModelFactory {
        return TbbViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideTbwViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): TbwViewModelFactory {
        return TbwViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideWthViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
    ): WthViewModelFactory {
        return WthViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
        )
    }

    @Provides
    fun provideCalcViewModelFactory(
    ): CalcViewModelFactory {
        return CalcViewModelFactory(
        )
    }

    @Provides
    fun provideEditDreamViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getDreamFromDbByUserIdUseCase: GetDreamFromDbByUserIdUseCase,
        getDreamInfoFromDbByDreamIdUseCaseFactory: GetDreamInfoFromDbByDreamIdUseCase,
    ): EditDreamViewModelFactory {
        return EditDreamViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getDreamFromDbByUserIdUseCase = getDreamFromDbByUserIdUseCase,
            getDreamInfoFromDbByDreamIdUseCaseFactory = getDreamInfoFromDbByDreamIdUseCaseFactory,
        )
    }

    @Provides
    fun provideEditMentalViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getMentalConditionFromDbByUserIdUseCase: GetMentalConditionFromDbByUserIdUseCase,
        getMentalInfoFromDbByMentalConditionIdUseCase: GetMentalInfoFromDbByMentalConditionIdUseCase,
    ): EditMentalViewModelFactory {
        return EditMentalViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getMentalConditionFromDbByUserIdUseCase = getMentalConditionFromDbByUserIdUseCase,
            getMentalInfoFromDbByMentalConditionIdUseCase = getMentalInfoFromDbByMentalConditionIdUseCase,
        )
    }

    @Provides
    fun provideEditPhysicalViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getPhysicalConditionFromDbByUserIdUseCase: GetPhysicalConditionFromDbByUserIdUseCase,
        getPhysicalInfoFromDbByPhysicalConditionIdUseCase: GetPhysicalInfoFromDbByPhysicalConditionIdUseCase,
    ): EditPhysicalViewModelFactory {
        return EditPhysicalViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getPhysicalConditionFromDbByUserIdUseCase = getPhysicalConditionFromDbByUserIdUseCase,
            getPhysicalInfoFromDbByPhysicalConditionIdUseCase = getPhysicalInfoFromDbByPhysicalConditionIdUseCase,
        )
    }

    @Provides
    fun provideMainViewModelFactory(
    ): MainViewModelFactory {
        return MainViewModelFactory(
        )
    }

    @Provides
    fun provideBiometricsViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserParameterFromDbByUserIdUseCase: GetUserParameterFromDbByUserIdUseCase,
        saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
    ): BiometricsViewModelFactory {
        return BiometricsViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserParameterFromDbByUserIdUseCase = getUserParameterFromDbByUserIdUseCase,
            saveUserParameterToDbUseCase = saveUserParameterToDbUseCase,
        )
    }

    @Provides
    fun provideGetPremiumViewModelFactory(
    ): GetPremiumViewModelFactory {
        return GetPremiumViewModelFactory(
        )
    }

    @Provides
    fun provideUserSetupViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
        saveUserToDbUseCase: SaveUserToDbUseCase,
    ): UserSetupViewModelFactory {
        return UserSetupViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
        )
    }

    @Provides
    fun provideProfileViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    ): ProfileViewModelFactory {
        return ProfileViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        )
    }

    @Provides
    fun provideEditMedicineViewModelFactory(
        getMedicineInfoTimesFromDbByMedicineInfoIdUseCase: GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase
    ): EditMedicineViewModelFactory {
        return EditMedicineViewModelFactory(
            getMedicineInfoTimesFromDbByMedicineInfoIdUseCase = getMedicineInfoTimesFromDbByMedicineInfoIdUseCase
        )
    }

    @Provides
    fun provideScheduleViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getWaterFromDbByUserIdUseCase: GetWaterFromDbByUserIdUseCase,
        getFoodFromDbByUserIdUseCase: GetFoodFromDbByUserIdUseCase,
        getMedicineFromDbByUserIdUseCase: GetMedicineFromDbByUserIdUseCase,
        getMedicineInfoFromDbByMedicineIdUseCase: GetMedicineInfoFromDbByMedicineIdUseCase,
        getWeightFromDbByUserIdUseCase: GetWeightFromDbByUserIdUseCase,
        getPressureFromDbByUserIdUseCase: GetPressureFromDbByUserIdUseCase,
        saveWaterToDbUseCase: SaveWaterToDbUseCase,
        saveFoodToDbUseCase: SaveFoodToDbUseCase,
        saveMedicineToDbUseCase: SaveMedicineToDbUseCase,
        saveMedicineInfoToDbUseCase: SaveMedicineInfoToDbUseCase,
        saveWeightToDbUseCase: SaveWeightToDbUseCase,
        savePressureToDbUseCase: SavePressureToDbUseCase,
    ): ScheduleViewModelFactory {
        return ScheduleViewModelFactory(
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
        )
    }
}