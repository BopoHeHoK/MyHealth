package com.test.myhealth.app.di

import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.useCase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserIdFromSharedPrefsUseCase(userRepository: UserRepository): GetUserIdFromSharedPrefsUseCase {
        return GetUserIdFromSharedPrefsUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSetUserIdToSharedPrefsUseCase(userRepository: UserRepository): SetUserIdToSharedPrefsUseCase {
        return SetUserIdToSharedPrefsUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetArticlesFromDbUseCase(userRepository: UserRepository): GetArticlesFromDbUseCase {
        return GetArticlesFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetDreamFromDbByUserIdUseCase(userRepository: UserRepository): GetDreamFromDbByUserIdUseCase {
        return GetDreamFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetDreamInfoFromDbByDreamIdUseCase(userRepository: UserRepository): GetDreamInfoFromDbByDreamIdUseCase {
        return GetDreamInfoFromDbByDreamIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetFoodFromDbByUserIdUseCaseuserRepository(userRepository: UserRepository): GetFoodFromDbByUserIdUseCase {
        return GetFoodFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetMedicineFromDbByUserIdUseCase(userRepository: UserRepository): GetMedicineFromDbByUserIdUseCase {
        return GetMedicineFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetMedicineInfoFromDbByMedicineIdUseCase(userRepository: UserRepository): GetMedicineInfoFromDbByMedicineIdUseCase {
        return GetMedicineInfoFromDbByMedicineIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetMedicineInfoTimesFromDbByMedicineInfoIdUseCase(userRepository: UserRepository): GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase {
        return GetMedicineInfoTimesFromDbByMedicineInfoIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetMentalConditionFromDbByUserIdUseCase(userRepository: UserRepository): GetMentalConditionFromDbByUserIdUseCase {
        return GetMentalConditionFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetMentalInfoFromDbByMentalConditionIdUseCase(userRepository: UserRepository): GetMentalInfoFromDbByMentalConditionIdUseCase {
        return GetMentalInfoFromDbByMentalConditionIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetPhysicalConditionFromDbByUserIdUseCase(userRepository: UserRepository): GetPhysicalConditionFromDbByUserIdUseCase {
        return GetPhysicalConditionFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetPhysicalInfoFromDbByPhysicalConditionIdUseCase(userRepository: UserRepository): GetPhysicalInfoFromDbByPhysicalConditionIdUseCase {
        return GetPhysicalInfoFromDbByPhysicalConditionIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetPressureFromDbByUserIdUseCase(userRepository: UserRepository): GetPressureFromDbByUserIdUseCase {
        return GetPressureFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetRatingsFromDbByUserIdUseCase(userRepository: UserRepository): GetRatingsFromDbByUserIdUseCase {
        return GetRatingsFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserFavoriteArticleFromDbByUserIdUseCase(userRepository: UserRepository): GetUserFavoriteArticleFromDbByUserIdUseCase {
        return GetUserFavoriteArticleFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserFromDbByIdUseCase(userRepository: UserRepository): GetUserFromDbByIdUseCase {
        return GetUserFromDbByIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserParameterFromDbByUserIdUseCase(userRepository: UserRepository): GetUserParameterFromDbByUserIdUseCase {
        return GetUserParameterFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetWaterFromDbByUserIdUseCase(userRepository: UserRepository): GetWaterFromDbByUserIdUseCase {
        return GetWaterFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetWeightFromDbByUserIdUseCase(userRepository: UserRepository): GetWeightFromDbByUserIdUseCase {
        return GetWeightFromDbByUserIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveArticlesToDbUseCase(userRepository: UserRepository): SaveArticlesToDbUseCase {
        return SaveArticlesToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveDreamInfoToDbUseCase(userRepository: UserRepository): SaveDreamInfoToDbUseCase {
        return SaveDreamInfoToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveDreamToDbUseCase(userRepository: UserRepository): SaveDreamToDbUseCase {
        return SaveDreamToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveFoodToDbUseCase(userRepository: UserRepository): SaveFoodToDbUseCase {
        return SaveFoodToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveGendersToDbUseCase(userRepository: UserRepository): SaveGenderToDbUseCase {
        return SaveGenderToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveMedicineInfoTimeToDbUseCase(userRepository: UserRepository): SaveMedicineInfoTimeToDbUseCase {
        return SaveMedicineInfoTimeToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveMedicineInfoToDbUseCase(userRepository: UserRepository): SaveMedicineInfoToDbUseCase {
        return SaveMedicineInfoToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveMedicineToDbUseCase(userRepository: UserRepository): SaveMedicineToDbUseCase {
        return SaveMedicineToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveMentalConditionToDbUseCase(userRepository: UserRepository): SaveMentalConditionToDbUseCase {
        return SaveMentalConditionToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveMentalInfoUserToDbUseCase(userRepository: UserRepository): SaveMentalInfoUserToDbUseCase {
        return SaveMentalInfoUserToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSavePhysicalConditionToDbUseCase(userRepository: UserRepository): SavePhysicalConditionToDbUseCase {
        return SavePhysicalConditionToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSavePhysicalInfoToDbUseCase(userRepository: UserRepository): SavePhysicalInfoToDbUseCase {
        return SavePhysicalInfoToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSavePressureToDbUseCase(userRepository: UserRepository): SavePressureToDbUseCase {
        return SavePressureToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveRatingToDbUseCase(userRepository: UserRepository): SaveRatingToDbUseCase {
        return SaveRatingToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveRolesToDbUseCase(userRepository: UserRepository): SaveRoleToDbUseCase {
        return SaveRoleToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserFavoriteArticleToDbUseCase(userRepository: UserRepository): SaveUserFavoriteArticleToDbUseCase {
        return SaveUserFavoriteArticleToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserParameterToDbUseCase(userRepository: UserRepository): SaveUserParameterToDbUseCase {
        return SaveUserParameterToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserToDbUseCase(userRepository: UserRepository): SaveUserToDbUseCase {
        return SaveUserToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveWaterToDbUseCase(userRepository: UserRepository): SaveWaterToDbUseCase {
        return SaveWaterToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveWeightToDbUseCase(userRepository: UserRepository): SaveWeightToDbUseCase {
        return SaveWeightToDbUseCase(userRepository = userRepository)
    }
}