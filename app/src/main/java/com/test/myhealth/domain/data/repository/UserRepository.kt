package com.test.myhealth.domain.data.repository

import androidx.lifecycle.LiveData
import com.test.myhealth.domain.model.*

interface UserRepository {

    fun setUserIdSharedPreferences(id: Long)

    fun getUserIdSharedPreferences(): Long

    fun getUserFromDb(id: Long): User

    fun getUserParameterFromDb(userId: Long): UserParameter

    fun getRatingsFromDb(userId: Long): List<Rating>

    fun getUserFavoriteArticleFromDb(userId: Long): UserFavoriteArticle

    fun getDreamFromDb(userId: Long): List<Dream>

    fun getDreamInfoFromDb(dreamId: Long): List<DreamInfo>

    fun getPhysicalConditionFromDb(userId: Long): List<PhysicalCondition>

    fun getPhysicalInfoFromDb(physicalConditionId: Long): List<PhysicalInfo>

    fun getMentalConditionFromDb(userId: Long): List<MentalCondition>

    fun getMentalInfoFromDb(mentalConditionId: Long): List<MentalInfo>

    fun getWaterFromDb(userId: Long): Water

    fun getFoodFromDb(userId: Long): Food

    fun getMedicineFromDb(userId: Long): Medicine

    fun getMedicineInfoFromDb(medicineId: Long): List<MedicineInfo>

    fun getMedicineInfoTimesFromDb(medicineInfoId: Long): List<MedicineInfoTime>

    fun getWeightFromDb(userId: Long): Weight

    fun getPressureFromDb(userId: Long): Pressure

    fun getArticlesFromDb(): List<Article>

    suspend fun saveRolesToDb(role: Role)

    suspend fun saveGendersToDB(gender: Gender)

    suspend fun saveUserToDb(user: User)

    suspend fun saveUserParameterToDb(userParameter: UserParameter)

    suspend fun saveRatingToDb(rating: Rating)

    suspend fun saveUserFavoriteArticleToDb(userFavoriteArticle: UserFavoriteArticle)

    suspend fun saveDreamToDb(dream: Dream)

    suspend fun saveDreamInfoToDb(dreamInfo: DreamInfo)

    suspend fun savePhysicalConditionToDb(physicalCondition: PhysicalCondition)

    suspend fun savePhysicalInfoToDb(physicalInfo: PhysicalInfo)

    suspend fun saveMentalConditionToDb(mentalCondition: MentalCondition)

    suspend fun saveMentalInfoToDb(mentalInfo: MentalInfo)

    suspend fun saveWaterToDb(water: Water)

    suspend fun saveFoodToDb(food: Food)

    suspend fun saveMedicineToDb(medicine: Medicine)

    suspend fun saveMedicineInfoToDb(medicineInfo: MedicineInfo)

    suspend fun saveMedicineInfoTimeToDb(medicineInfoTime: MedicineInfoTime)

    suspend fun saveWeightToDb(weight: Weight)

    suspend fun savePressureToDb(pressure: Pressure)

    suspend fun saveArticlesToDb(article: Article)
}