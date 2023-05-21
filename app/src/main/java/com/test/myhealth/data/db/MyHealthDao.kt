package com.test.myhealth.data.db

import androidx.room.*
import com.test.myhealth.data.storage.modelDb.*

@Dao
interface MyHealthDao {

    //ROLE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRole(roleEntity: RoleEntity)

    //ROLE//


    //GENDER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertGender(genderEntity: GenderEntity)

    //GENDER//

    //USER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUser(userEntity: UserEntity)

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Long): UserEntity

    //USER//

    //USER_PARAMETER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUserParameter(userParameterEntity: UserParameterEntity)

    @Query("SELECT * FROM user_parameters WHERE user_id = :userId")
    fun getUserParameter(userId: Long): UserParameterEntity

    //USER_PARAMETER//

    //RATING//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRating(ratingEntity: RatingEntity)

    @Query("SELECT * FROM ratings WHERE user_id = :userId")
    fun getAllUserRatings(userId: Long): List<RatingEntity>

    //RATING//

    //USER_FAVORITE_ARTICLES//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUserFavoriteArticle(userFavoriteArticlesEntity: UserFavoriteArticlesEntity)

    @Query("SELECT * FROM user_favorite_articles WHERE user_id = :userId")
    fun getUserFavoriteArticles(userId: Long): UserFavoriteArticlesEntity

    //USER_FAVORITE_ARTICLES//

    //DREAM//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDream(dreamEntity: DreamEntity)

    @Query("SELECT * FROM dreams WHERE user_id = :userId")
    fun getAllUserDream(userId: Long): List<DreamEntity>

    //DREAM//

    //DREAM_INFO//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDreamInfo(dreamInfoEntity: DreamInfoEntity)

    @Query("SELECT * FROM dream_info WHERE dream_id = :dreamId")
    fun getAllDreamInfo(dreamId: Long): List<DreamInfoEntity>

    //DREAM_INFO//

    //PHYSICAL_CONDITION//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPhysicalCondition(physicalConditionEntity: PhysicalConditionEntity)

    @Query("SELECT * FROM physical_conditions WHERE user_id = :userId")
    fun getAllUserPhysicalCondition(userId: Long): List<PhysicalConditionEntity>

    //PHYSICAL_CONDITION//

    //PHYSICAL_INFO//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPhysicalInfo(physicalInfoEntity: PhysicalInfoEntity)

    @Query("SELECT * FROM physical_info WHERE physical_condition_id = :physicalConditionId")
    fun getAllPhysicalInfo(physicalConditionId: Long): List<PhysicalInfoEntity>

    //PHYSICAL_INFO//

    //MENTAL_CONDITION//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMentalCondition(mentalConditionEntity: MentalConditionEntity)

    @Query("SELECT * FROM mental_conditions WHERE user_id = :userId")
    fun getAllUserMentalCondition(userId: Long): List<MentalConditionEntity>

    //MENTAL_CONDITION//

    //MENTAL_INFO//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMentalInfo(mentalInfoEntity: MentalInfoEntity)

    @Query("SELECT * FROM mental_info WHERE mental_condition_id = :mentalConditionId")
    fun getAllMentalInfo(mentalConditionId: Long): List<MentalInfoEntity>

    //MENTAL_INFO//

    //WATER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertWater(waterEntity: WaterEntity)

    @Query("SELECT * FROM water WHERE user_id = :userId")
    fun getWater(userId: Long): WaterEntity

    //WATER//

    //FOOD//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertFood(foodEntity: FoodEntity)

    @Query("SELECT * FROM food WHERE user_id = :userId")
    fun getFood(userId: Long): FoodEntity

    //FOOD//

    //MEDICINE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMedicine(medicineEntity: MedicineEntity)

    @Query("SELECT * FROM medicine WHERE user_id = :userId")
    fun getMedicine(userId: Long): MedicineEntity

    //MEDICINE//

    //MEDICINE_INFO//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMedicineInfo(medicineInfoEntity: MedicineInfoEntity)

    @Query("SELECT * FROM medicine_info WHERE medicine_id = :medicineId")
    fun getAllMedicineInfo(medicineId: Long): List<MedicineInfoEntity>

    //MEDICINE_INFO//

    //MEDICINE_INFO_TIME//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMedicineInfoTime(medicineInfoTimeEntity: MedicineInfoTimeEntity)

    @Query("SELECT * FROM medicine_info_times WHERE medicine_info_id = :medicineInfoId")
    fun getAllMedicineInfoTime(medicineInfoId: Long): List<MedicineInfoTimeEntity>

    //MEDICINE_INFO_TIME//

    //WEIGHT//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertWeight(weightEntity: WeightEntity)

    @Query("SELECT * FROM weight WHERE user_id = :userId")
    fun getWeight(userId: Long): WeightEntity

    //WEIGHT//

    //PRESSURE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPressure(pressureEntity: PressureEntity)

    @Query("SELECT * FROM pressure WHERE user_id = :userId")
    fun getPressure(userId: Long): PressureEntity

    //PRESSURE//

    //ARTICLE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticle(articleEntity: ArticleEntity)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<ArticleEntity>

    //ARTICLE//
}