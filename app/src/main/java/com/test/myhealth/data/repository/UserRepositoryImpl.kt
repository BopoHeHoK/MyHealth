package com.test.myhealth.data.repository

import android.util.Log
import com.test.myhealth.data.db.MyHealthDatabase
import com.test.myhealth.data.storage.converters.ConverterEM
import com.test.myhealth.data.storage.converters.ConverterME
import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.data.repository.UserStorage
import com.test.myhealth.domain.model.*

class UserRepositoryImpl(
    private val userStorage: UserStorage,
    private val myHealthDatabase: MyHealthDatabase,
    private val converterEM: ConverterEM,
    private val converterME: ConverterME,
) : UserRepository {

    override fun setUserIdSharedPreferences(id: Long) {
        userStorage.setUserId(id = id)
    }

    override fun getUserIdSharedPreferences(): Long {
        return userStorage.getUserId()
    }

    override fun getUserFromDb(id: Long): User {
        return converterEM.toUserModel(myHealthDatabase.myHealthDao().getUser(id = id))
    }

    override fun getUserParameterFromDb(userId: Long): UserParameter {
        return converterEM.toUserParameterModel(
            myHealthDatabase.myHealthDao().getUserParameter(userId = userId)
        )
    }

    override fun getRatingsFromDb(userId: Long): List<Rating> {
        return converterEM.toRatingModelList(
            myHealthDatabase.myHealthDao().getAllUserRatings(userId = userId)
        )
    }

    override fun getUserFavoriteArticleFromDb(userId: Long): UserFavoriteArticle {
        return converterEM.toUserFavoriteArticlesModel(
            myHealthDatabase.myHealthDao().getUserFavoriteArticles(userId = userId)
        )
    }

    override fun getDreamFromDb(userId: Long): List<Dream> {
        return converterEM.toDreamModelList(
            myHealthDatabase.myHealthDao().getAllUserDream(userId = userId)
        )
    }

    override fun getDreamInfoFromDb(dreamId: Long): List<DreamInfo> {
        return converterEM.toDreamInfoModelList(
            myHealthDatabase.myHealthDao().getAllDreamInfo(dreamId = dreamId)
        )
    }

    override fun getPhysicalConditionFromDb(userId: Long): List<PhysicalCondition> {
        return converterEM.toPhysicalConditionModelList(
            myHealthDatabase.myHealthDao().getAllUserPhysicalCondition(userId = userId)
        )
    }

    override fun getPhysicalInfoFromDb(physicalConditionId: Long): List<PhysicalInfo> {
        return converterEM.toPhysicalInfoModelList(
            myHealthDatabase.myHealthDao()
                .getAllPhysicalInfo(physicalConditionId = physicalConditionId)
        )
    }

    override fun getMentalConditionFromDb(userId: Long): List<MentalCondition> {
        return converterEM.toMentalConditionModelList(
            myHealthDatabase.myHealthDao().getAllUserMentalCondition(userId = userId)
        )
    }

    override fun getMentalInfoFromDb(mentalConditionId: Long): List<MentalInfo> {
        return converterEM.toMentalInfoModelList(
            myHealthDatabase.myHealthDao().getAllMentalInfo(mentalConditionId = mentalConditionId)
        )
    }

    override fun getWaterFromDb(userId: Long): Water {
        return converterEM.toWaterModel(myHealthDatabase.myHealthDao().getWater(userId = userId))
    }

    override fun getFoodFromDb(userId: Long): Food {
        return converterEM.toFoodModel(myHealthDatabase.myHealthDao().getFood(userId = userId))
    }

    override fun getMedicineFromDb(userId: Long): Medicine {
        return converterEM.toMedicineModel(
            myHealthDatabase.myHealthDao().getMedicine(userId = userId)
        )
    }

    override fun getMedicineInfoFromDb(medicineId: Long): List<MedicineInfo> {
        return converterEM.toMedicineInfoModelList(
            myHealthDatabase.myHealthDao().getAllMedicineInfo(medicineId = medicineId)
        )
    }

    override fun getMedicineInfoTimesFromDb(medicineInfoId: Long): List<MedicineInfoTime> {
        return converterEM.toMedicineInfoTimeModelList(
            myHealthDatabase.myHealthDao().getAllMedicineInfoTime(medicineInfoId = medicineInfoId)
        )
    }

    override fun getWeightFromDb(userId: Long): Weight {
        return converterEM.toWeightModel(myHealthDatabase.myHealthDao().getWeight(userId = userId))
    }

    override fun getPressureFromDb(userId: Long): Pressure {
        return converterEM.toPressureModel(
            myHealthDatabase.myHealthDao().getPressure(userId = userId)
        )
    }

    override fun getArticlesFromDb(): List<Article> {
        return converterEM.toArticleModelList(myHealthDatabase.myHealthDao().getAllArticles())
    }

    override suspend fun saveRolesToDb(role: Role) {
        myHealthDatabase.myHealthDao().upsertRole(converterME.toRoleEntity(role = role))
    }

    override suspend fun saveGendersToDB(gender: Gender) {
        myHealthDatabase.myHealthDao().upsertGender(converterME.toGenderEntity(gender = gender))
    }

    override suspend fun saveUserToDb(user: User) {
        myHealthDatabase.myHealthDao().upsertUser(converterME.toUserEntity(user = user))
    }

    override suspend fun saveUserParameterToDb(userParameter: UserParameter) {
        myHealthDatabase.myHealthDao()
            .upsertUserParameter(converterME.toUserParameterEntity(userParameter = userParameter))
    }

    override suspend fun saveRatingToDb(rating: Rating) {
        myHealthDatabase.myHealthDao().upsertRating(converterME.toRatingEntity(rating = rating))
    }

    override suspend fun saveUserFavoriteArticleToDb(userFavoriteArticle: UserFavoriteArticle) {
        myHealthDatabase.myHealthDao()
            .upsertUserFavoriteArticle(converterME.toUserFavoriteArticlesEntity(userFavoriteArticle = userFavoriteArticle))
    }

    override suspend fun saveDreamToDb(dream: Dream) {
        myHealthDatabase.myHealthDao().upsertDream(converterME.toDreamEntity(dream = dream))
    }

    override suspend fun saveDreamInfoToDb(dreamInfo: DreamInfo) {
        myHealthDatabase.myHealthDao()
            .upsertDreamInfo(converterME.toDreamInfoEntity(dreamInfo = dreamInfo))
    }

    override suspend fun savePhysicalConditionToDb(physicalCondition: PhysicalCondition) {
        myHealthDatabase.myHealthDao()
            .upsertPhysicalCondition(converterME.toPhysicalConditionEntity(physicalCondition = physicalCondition))
    }

    override suspend fun savePhysicalInfoToDb(physicalInfo: PhysicalInfo) {
        myHealthDatabase.myHealthDao()
            .upsertPhysicalInfo(converterME.toPhysicalInfoEntity(physicalInfo = physicalInfo))
    }

    override suspend fun saveMentalConditionToDb(mentalCondition: MentalCondition) {
        myHealthDatabase.myHealthDao()
            .upsertMentalCondition(converterME.toMentalConditionEntity(mentalCondition = mentalCondition))
    }

    override suspend fun saveMentalInfoToDb(mentalInfo: MentalInfo) {
        myHealthDatabase.myHealthDao()
            .upsertMentalInfo(converterME.toMentalInfoEntity(mentalInfo = mentalInfo))
    }

    override suspend fun saveWaterToDb(water: Water) {
        myHealthDatabase.myHealthDao().upsertWater(converterME.toWaterEntity(water = water))
    }

    override suspend fun saveFoodToDb(food: Food) {
        myHealthDatabase.myHealthDao().upsertFood(converterME.toFoodEntity(food = food))
    }

    override suspend fun saveMedicineToDb(medicine: Medicine) {
        myHealthDatabase.myHealthDao()
            .upsertMedicine(converterME.toMedicineEntity(medicine = medicine))
    }

    override suspend fun saveMedicineInfoToDb(medicineInfo: MedicineInfo) {
        myHealthDatabase.myHealthDao()
            .upsertMedicineInfo(converterME.toMedicineInfoEntity(medicineInfo = medicineInfo))
    }

    override suspend fun saveMedicineInfoTimeToDb(medicineInfoTime: MedicineInfoTime) {
        myHealthDatabase.myHealthDao()
            .upsertMedicineInfoTime(converterME.toMedicineInfoTimeEntity(medicineInfoTime = medicineInfoTime))
    }

    override suspend fun saveWeightToDb(weight: Weight) {
        myHealthDatabase.myHealthDao().upsertWeight(converterME.toWeightEntity(weight = weight))
    }

    override suspend fun savePressureToDb(pressure: Pressure) {
        myHealthDatabase.myHealthDao()
            .upsertPressure(converterME.toPressureEntity(pressure = pressure))
    }

    override suspend fun saveArticlesToDb(article: Article) {
        myHealthDatabase.myHealthDao().upsertArticle(converterME.toArticleEntity(article))
    }
}