package com.test.myhealth.data.storage.converters

import com.test.myhealth.data.storage.modelDb.*
import com.test.myhealth.domain.model.*

interface ConverterEM {
    fun toUserModel(userEntity: UserEntity): User
    fun toUserParameterModel(userParameterEntity: UserParameterEntity): UserParameter
    fun toRatingModelList(ratingEntityList: List<RatingEntity>): List<Rating>
    fun toUserFavoriteArticlesModel(userFavoriteArticleEntity: UserFavoriteArticlesEntity): UserFavoriteArticle
    fun toDreamModelList(dreamEntityList: List<DreamEntity>): List<Dream>
    fun toDreamInfoModelList(dreamInfoEntityList: List<DreamInfoEntity>): List<DreamInfo>
    fun toPhysicalConditionModelList(physicalConditionEntityList: List<PhysicalConditionEntity>): List<PhysicalCondition>
    fun toPhysicalInfoModelList(physicalInfoEntityList: List<PhysicalInfoEntity>): List<PhysicalInfo>
    fun toMentalConditionModelList(mentalConditionEntityList: List<MentalConditionEntity>): List<MentalCondition>
    fun toMentalInfoModelList(mentalInfoEntityList: List<MentalInfoEntity>): List<MentalInfo>
    fun toWaterModel(waterEntity: WaterEntity): Water
    fun toFoodModel(foodEntity: FoodEntity): Food
    fun toMedicineModel(medicineEntity: MedicineEntity): Medicine
    fun toMedicineInfoModelList(medicineInfoEntityList: List<MedicineInfoEntity>): List<MedicineInfo>
    fun toMedicineInfoTimeModelList(medicineInfoTimeEntityList: List<MedicineInfoTimeEntity>): List<MedicineInfoTime>
    fun toWeightModel(weightEntity: WeightEntity): Weight
    fun toPressureModel(pressureEntity: PressureEntity): Pressure
    fun toArticleModelList(articleEntityList: List<ArticleEntity>): List<Article>
}

class ConverterEMImpl : ConverterEM {

    override fun toUserModel(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            email = userEntity.email,
            phoneNumber = userEntity.phoneNumber,
            firstName = userEntity.firstName,
            lastName = userEntity.lastName,
            roleId = userEntity.roleId
        )
    }

    override fun toUserParameterModel(userParameterEntity: UserParameterEntity): UserParameter {
        return UserParameter(
            id = userParameterEntity.id,
            age = userParameterEntity.age,
            height = userParameterEntity.height,
            weight = userParameterEntity.weight,
            waist = userParameterEntity.waist,
            userId = userParameterEntity.userId,
            genderId = userParameterEntity.genderId,
        )
    }

    override fun toRatingModelList(ratingEntityList: List<RatingEntity>): List<Rating> {
        val result = ArrayList<Rating>()
        ratingEntityList.forEach {
            val converted = Rating(
                id = it.id,
                isLike = it.isLike,
                userId = it.userId,
                articleId = it.articleId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toUserFavoriteArticlesModel(userFavoriteArticleEntity: UserFavoriteArticlesEntity): UserFavoriteArticle {
        return UserFavoriteArticle(
            id = userFavoriteArticleEntity.id,
            userId = userFavoriteArticleEntity.userId,
        )
    }

    override fun toDreamModelList(dreamEntityList: List<DreamEntity>): List<Dream> {
        val result = ArrayList<Dream>()
        dreamEntityList.forEach {
            val converted = Dream(
                id = it.id,
                date = it.date,
                quality = it.quality,
                userId = it.userId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toDreamInfoModelList(dreamInfoEntityList: List<DreamInfoEntity>): List<DreamInfo> {
        val result = ArrayList<DreamInfo>()
        dreamInfoEntityList.forEach {
            val converted = DreamInfo(
                id = it.id,
                note = it.note,
                dreamId = it.dreamId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toPhysicalConditionModelList(physicalConditionEntityList: List<PhysicalConditionEntity>): List<PhysicalCondition> {
        val result = ArrayList<PhysicalCondition>()
        physicalConditionEntityList.forEach {
            val converted = PhysicalCondition(
                id = it.id,
                date = it.date,
                quality = it.quality,
                userId = it.userId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toPhysicalInfoModelList(physicalInfoEntityList: List<PhysicalInfoEntity>): List<PhysicalInfo> {
        val result = ArrayList<PhysicalInfo>()
        physicalInfoEntityList.forEach {
            val converted = PhysicalInfo(
                id = it.id,
                note = it.note,
                physicalConditionId = it.physicalConditionId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toMentalConditionModelList(mentalConditionEntityList: List<MentalConditionEntity>): List<MentalCondition> {
        val result = ArrayList<MentalCondition>()
        mentalConditionEntityList.forEach {
            val converted = MentalCondition(
                id = it.id,
                date = it.date,
                quality = it.quality,
                userId = it.userId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toMentalInfoModelList(mentalInfoEntityList: List<MentalInfoEntity>): List<MentalInfo> {
        val result = ArrayList<MentalInfo>()
        mentalInfoEntityList.forEach {
            val converted = MentalInfo(
                id = it.id,
                note = it.note,
                mentalConditionId = it.mentalConditionId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toWaterModel(waterEntity: WaterEntity): Water {
        return Water(
            id = waterEntity.id,
            mode = waterEntity.mode,
            periodicity = waterEntity.periodicity,
            userId = waterEntity.userId,
        )
    }

    override fun toFoodModel(foodEntity: FoodEntity): Food {
        return Food(
            id = foodEntity.id,
            mode = foodEntity.mode,
            time1 = foodEntity.time1,
            time1_mode = foodEntity.time1_mode,
            time2 = foodEntity.time2,
            time2_mode = foodEntity.time2_mode,
            time3 = foodEntity.time3,
            time3_mode = foodEntity.time3_mode,
            time4 = foodEntity.time4,
            time4_mode = foodEntity.time4_mode,
            time5 = foodEntity.time5,
            time5_mode = foodEntity.time5_mode,
            userId = foodEntity.userId,
        )
    }

    override fun toMedicineModel(medicineEntity: MedicineEntity): Medicine {
        return Medicine(
            id = medicineEntity.id,
            mode = medicineEntity.mode,
            userId = medicineEntity.userId,
        )
    }

    override fun toMedicineInfoModelList(medicineInfoEntityList: List<MedicineInfoEntity>): List<MedicineInfo> {
        val result = ArrayList<MedicineInfo>()
        medicineInfoEntityList.forEach {
            val converted = MedicineInfo(
                id = it.id,
                mode = it.mode,
                medicine_name = it.medicine_name,
                medicine_dosage = it.medicine_dosage,
                disease_name = it.disease_name,
                start_day = it.start_day,
                end_day = it.end_day,
                medicineId = it.medicineId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toMedicineInfoTimeModelList(medicineInfoTimeEntityList: List<MedicineInfoTimeEntity>): List<MedicineInfoTime> {
        val result = ArrayList<MedicineInfoTime>()
        medicineInfoTimeEntityList.forEach {
            val converted = MedicineInfoTime(
                id = it.id,
                time = it.time,
                medicineInfoId = it.medicineInfoId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toWeightModel(weightEntity: WeightEntity): Weight {
        return Weight(
            id = weightEntity.id,
            mode = weightEntity.mode,
            monday = weightEntity.monday,
            tuesday = weightEntity.tuesday,
            wednesday = weightEntity.wednesday,
            thursday = weightEntity.thursday,
            friday = weightEntity.friday,
            saturday = weightEntity.saturday,
            sunday = weightEntity.sunday,
            time = weightEntity.time,
            userId = weightEntity.userId,
        )
    }

    override fun toPressureModel(pressureEntity: PressureEntity): Pressure {
        return Pressure(
            id = pressureEntity.id,
            mode = pressureEntity.mode,
            time1 = pressureEntity.time1,
            time1_mode = pressureEntity.time1_mode,
            time2 = pressureEntity.time2,
            time2_mode = pressureEntity.time2_mode,
            time3 = pressureEntity.time3,
            time3_mode = pressureEntity.time3_mode,
            userId = pressureEntity.userId,
        )
    }

    override fun toArticleModelList(articleEntityList: List<ArticleEntity>): List<Article> {
        val result = ArrayList<Article>()
        articleEntityList.forEach {
            val converted = Article(
                id = it.id,
                title = it.title,
                content = it.content,
                img = it.img,
                favorites = it.favorites,
                likes = it.likes
            )
            result.add(converted)
        }
        return result
    }
}

