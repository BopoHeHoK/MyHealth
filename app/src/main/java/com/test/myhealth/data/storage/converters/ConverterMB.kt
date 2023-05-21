package com.test.myhealth.data.storage.converters

import com.test.myhealth.data.storage.modelApi.*
import com.test.myhealth.domain.model.*

interface ConverterMB {
    fun toUserBody(user: User): UserBodyToSave
    fun toUserParameterBody(userParameter: UserParameter): UserParameterBody
    fun toRatingBodyList(ratingList: List<Rating>): List<RatingBody>
    fun toUserFavoriteArticleBody(userFavoriteArticle: UserFavoriteArticle): UserFavoriteArticleBody
    fun toDreamBodyList(dreamList: List<Dream>): List<DreamBody>
    fun toDreamInfoBodyList(dreamInfoList: List<DreamInfo>): List<DreamInfoBody>
    fun toPhysicalConditionBodyList(physicalConditionList: List<PhysicalCondition>): List<PhysicalConditionBody>
    fun toPhysicalInfoBodyList(physicalInfoList: List<PhysicalInfo>): List<PhysicalInfoBody>
    fun toMentalConditionBodyList(mentalConditionList: List<MentalCondition>): List<MentalConditionBody>
    fun toMentalInfoBodyList(mentalInfoList: List<MentalInfo>): List<MentalInfoBody>
    fun toWaterBody(water: Water): WaterBody
    fun toFoodBody(food: Food): FoodBody
    fun toMedicineBody(medicine: Medicine): MedicineBody
    fun toMedicineInfoBodyList(medicineInfoList: List<MedicineInfo>): List<MedicineInfoBody>
    fun toMedicineInfoTimeBodyList(medicineInfoTimeList: List<MedicineInfoTime>): List<MedicineInfoTimeBody>
    fun toWeightBody(weight: Weight): WeightBody
    fun toPressureBody(pressure: Pressure): PressureBody
    fun toArticleBodyList(articleList: List<Article>): List<ArticleBody>
}

class ConverterMBImpl : ConverterMB {
    override fun toUserBody(user: User): UserBodyToSave {
        return UserBodyToSave(
            id = user.id,
            email = user.email,
            phone_number = user.phoneNumber,
            first_name = user.firstName,
            last_name = user.lastName,
            roleId = user.roleId
        )
    }

    override fun toUserParameterBody(userParameter: UserParameter): UserParameterBody {
        return UserParameterBody(
            id = userParameter.id,
            age = userParameter.age,
            height = userParameter.height,
            weight = userParameter.weight,
            waist = userParameter.waist,
            userId = userParameter.userId,
            genderId = userParameter.genderId,
        )
    }

    override fun toRatingBodyList(ratingList: List<Rating>): List<RatingBody> {
        TODO("Not yet implemented")
    }

    override fun toUserFavoriteArticleBody(userFavoriteArticle: UserFavoriteArticle): UserFavoriteArticleBody {
        TODO("Not yet implemented")
    }

    override fun toDreamBodyList(dreamList: List<Dream>): List<DreamBody> {
        TODO("Not yet implemented")
    }

    override fun toDreamInfoBodyList(dreamInfoList: List<DreamInfo>): List<DreamInfoBody> {
        TODO("Not yet implemented")
    }

    override fun toPhysicalConditionBodyList(physicalConditionList: List<PhysicalCondition>): List<PhysicalConditionBody> {
        TODO("Not yet implemented")
    }

    override fun toPhysicalInfoBodyList(physicalInfoList: List<PhysicalInfo>): List<PhysicalInfoBody> {
        TODO("Not yet implemented")
    }

    override fun toMentalConditionBodyList(mentalConditionList: List<MentalCondition>): List<MentalConditionBody> {
        TODO("Not yet implemented")
    }

    override fun toMentalInfoBodyList(mentalInfoList: List<MentalInfo>): List<MentalInfoBody> {
        TODO("Not yet implemented")
    }

    override fun toWaterBody(water: Water): WaterBody {
        TODO("Not yet implemented")
    }

    override fun toFoodBody(food: Food): FoodBody {
        TODO("Not yet implemented")
    }

    override fun toMedicineBody(medicine: Medicine): MedicineBody {
        TODO("Not yet implemented")
    }

    override fun toMedicineInfoBodyList(medicineInfoList: List<MedicineInfo>): List<MedicineInfoBody> {
        TODO("Not yet implemented")
    }

    override fun toMedicineInfoTimeBodyList(medicineInfoTimeList: List<MedicineInfoTime>): List<MedicineInfoTimeBody> {
        TODO("Not yet implemented")
    }

    override fun toWeightBody(weight: Weight): WeightBody {
        TODO("Not yet implemented")
    }

    override fun toPressureBody(pressure: Pressure): PressureBody {
        TODO("Not yet implemented")
    }

    override fun toArticleBodyList(articleList: List<Article>): List<ArticleBody> {
        TODO("Not yet implemented")
    }

}