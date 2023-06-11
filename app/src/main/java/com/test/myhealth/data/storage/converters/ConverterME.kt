package com.test.myhealth.data.storage.converters

import com.test.myhealth.data.storage.modelDb.*
import com.test.myhealth.domain.model.*

interface ConverterME {
    fun toRoleEntity(role: Role): RoleEntity
    fun toGenderEntity(gender: Gender): GenderEntity
    fun toUserEntity(user: User): UserEntity
    fun toUserParameterEntity(userParameter: UserParameter): UserParameterEntity
    fun toRatingEntity(rating: Rating): RatingEntity
    fun toUserFavoriteArticlesEntity(userFavoriteArticle: UserFavoriteArticle): UserFavoriteArticlesEntity
    fun toDreamEntity(dream: Dream): DreamEntity
    fun toDreamInfoEntity(dreamInfo: DreamInfo): DreamInfoEntity
    fun toPhysicalConditionEntity(physicalCondition: PhysicalCondition): PhysicalConditionEntity
    fun toPhysicalInfoEntity(physicalInfo: PhysicalInfo): PhysicalInfoEntity
    fun toMentalConditionEntity(mentalCondition: MentalCondition): MentalConditionEntity
    fun toMentalInfoEntity(mentalInfo: MentalInfo): MentalInfoEntity
    fun toWaterEntity(water: Water): WaterEntity
    fun toFoodEntity(food: Food): FoodEntity
    fun toMedicineEntity(medicine: Medicine): MedicineEntity
    fun toMedicineInfoEntity(medicineInfo: MedicineInfo): MedicineInfoEntity
    fun toMedicineInfoTimeEntity(medicineInfoTime: MedicineInfoTime): MedicineInfoTimeEntity
    fun toWeightEntity(weight: Weight): WeightEntity
    fun toPressureEntity(pressure: Pressure): PressureEntity
    fun toArticleEntity(article: Article): ArticleEntity
}

class ConverterMEImpl : ConverterME {
    override fun toRoleEntity(role: Role): RoleEntity {
        return RoleEntity(
            id = role.id,
            role = role.role
        )
    }

    override fun toGenderEntity(gender: Gender): GenderEntity {
        return GenderEntity(
            id = gender.id,
            gender = gender.gender
        )
    }

    override fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            email = user.email,
            phoneNumber = user.phoneNumber,
            firstName = user.firstName,
            lastName = user.lastName,
            roleId = user.roleId
        )
    }

    override fun toUserParameterEntity(userParameter: UserParameter): UserParameterEntity {
        return UserParameterEntity(
            id = userParameter.id,
            age = userParameter.age,
            height = userParameter.height,
            weight = userParameter.weight,
            waist = userParameter.waist,
            userId = userParameter.userId,
            genderId = userParameter.genderId,
        )
    }

    override fun toRatingEntity(rating: Rating): RatingEntity {
        return RatingEntity(
            id = rating.id,
            isLike = rating.isLike,
            userId = rating.userId,
            articleId = rating.articleId,
        )
    }

    override fun toUserFavoriteArticlesEntity(userFavoriteArticle: UserFavoriteArticle): UserFavoriteArticlesEntity {
        return UserFavoriteArticlesEntity(
            id = userFavoriteArticle.id,
            userId = userFavoriteArticle.userId,
        )
    }

    override fun toDreamEntity(dream: Dream): DreamEntity {
        return DreamEntity(
            id = dream.id,
            date = dream.date,
            quality = dream.quality,
            userId = dream.userId,
        )
    }

    override fun toDreamInfoEntity(dreamInfo: DreamInfo): DreamInfoEntity {
        return DreamInfoEntity(
            id = dreamInfo.id,
            note = dreamInfo.note,
            dreamId = dreamInfo.dreamId,
        )
    }

    override fun toPhysicalConditionEntity(physicalCondition: PhysicalCondition): PhysicalConditionEntity {
        return PhysicalConditionEntity(
            id = physicalCondition.id,
            date = physicalCondition.date,
            quality = physicalCondition.quality,
            userId = physicalCondition.userId,
        )
    }

    override fun toPhysicalInfoEntity(physicalInfo: PhysicalInfo): PhysicalInfoEntity {
        return PhysicalInfoEntity(
            id = physicalInfo.id,
            note = physicalInfo.note,
            physicalConditionId = physicalInfo.physicalConditionId,
        )
    }

    override fun toMentalConditionEntity(mentalCondition: MentalCondition): MentalConditionEntity {
        return MentalConditionEntity(
            id = mentalCondition.id,
            date = mentalCondition.date,
            quality = mentalCondition.quality,
            userId = mentalCondition.userId,
        )
    }

    override fun toMentalInfoEntity(mentalInfo: MentalInfo): MentalInfoEntity {
        return MentalInfoEntity(
            id = mentalInfo.id,
            note = mentalInfo.note,
            mentalConditionId = mentalInfo.mentalConditionId,
        )
    }

    override fun toWaterEntity(water: Water): WaterEntity {
        return WaterEntity(
            id = water.id,
            mode = water.mode,
            periodicity = water.periodicity,
            userId = water.userId,
        )
    }

    override fun toFoodEntity(food: Food): FoodEntity {
        return FoodEntity(
            id = food.id,
            mode = food.mode,
            time1 = food.time1,
            time1_mode = food.time1_mode,
            time2 = food.time2,
            time2_mode = food.time2_mode,
            time3 = food.time3,
            time3_mode = food.time3_mode,
            time4 = food.time4,
            time4_mode = food.time4_mode,
            time5 = food.time5,
            time5_mode = food.time5_mode,
            userId = food.userId,
        )
    }

    override fun toMedicineEntity(medicine: Medicine): MedicineEntity {
        return MedicineEntity(
            id = medicine.id,
            mode = medicine.mode,
            userId = medicine.userId,
        )
    }

    override fun toMedicineInfoEntity(medicineInfo: MedicineInfo): MedicineInfoEntity {
        return MedicineInfoEntity(
            id = medicineInfo.id,
            mode = medicineInfo.mode,
            medicine_name = medicineInfo.medicine_name,
            medicine_dosage = medicineInfo.medicine_dosage,
            disease_name = medicineInfo.disease_name,
            start_day = medicineInfo.start_day,
            end_day = medicineInfo.end_day,
            medicineId = medicineInfo.medicineId,
        )
    }

    override fun toMedicineInfoTimeEntity(medicineInfoTime: MedicineInfoTime): MedicineInfoTimeEntity {
        return MedicineInfoTimeEntity(
            id = medicineInfoTime.id,
            mode = medicineInfoTime.mode,
            time = medicineInfoTime.time,
            medicineInfoId = medicineInfoTime.medicineInfoId,
        )
    }

    override fun toWeightEntity(weight: Weight): WeightEntity {
        return WeightEntity(
            id = weight.id,
            mode = weight.mode,
            monday = weight.monday,
            tuesday = weight.tuesday,
            wednesday = weight.wednesday,
            thursday = weight.thursday,
            friday = weight.friday,
            saturday = weight.saturday,
            sunday = weight.sunday,
            time = weight.time,
            userId = weight.userId,
        )
    }

    override fun toPressureEntity(pressure: Pressure): PressureEntity {
        return PressureEntity(
            id = pressure.id,
            mode = pressure.mode,
            time1 = pressure.time1,
            time1_mode = pressure.time1_mode,
            time2 = pressure.time2,
            time2_mode = pressure.time2_mode,
            time3 = pressure.time3,
            time3_mode = pressure.time3_mode,
            userId = pressure.userId,
        )
    }

    override fun toArticleEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            id = article.id,
            title = article.title,
            content = article.content,
            img = article.img,
            favorites = article.favorites,
            likes = article.likes,
        )
    }
}