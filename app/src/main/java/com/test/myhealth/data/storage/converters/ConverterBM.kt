package com.test.myhealth.data.storage.converters

import com.test.myhealth.data.storage.modelApi.*
import com.test.myhealth.domain.model.*

interface ConverterBM {
    fun toUserModelList(userBodyToGet: UserBodyToGet): User
    fun toUserParameterModel(userParameterBody: UserParameterBody): UserParameter
    fun toRatingModelList(ratingBodyList: List<RatingBody>): List<Rating>
    fun toUserFavoriteArticleModel(userFavoriteArticleBody: UserFavoriteArticleBody): UserFavoriteArticle
    fun toDreamModelList(dreamBodyList: List<DreamBody>): List<Dream>
    fun toDreamInfoModelList(dreamInfoBodyList: List<DreamInfoBody>): List<DreamInfo>
    fun toPhysicalConditionModelList(physicalConditionBodyList: List<PhysicalConditionBody>): List<PhysicalCondition>
    fun toPhysicalInfoModelList(physicalInfoBodyList: List<PhysicalInfoBody>): List<PhysicalInfo>
    fun toMentalConditionModelList(mentalConditionBodyList: List<MentalConditionBody>): List<MentalCondition>
    fun toMentalInfoModelList(mentalInfoBodyList: List<MentalInfoBody>): List<MentalInfo>
    fun toWaterModel(waterBody: WaterBody): Water
    fun toFoodModel(foodBody: FoodBody): Food
    fun toMedicineModel(medicineBody: MedicineBody): Medicine
    fun toMedicineInfoModelList(medicineInfoBodyList: List<MedicineInfoBody>): List<MedicineInfo>
    fun toMedicineInfoTimeModelList(medicineInfoTimeBodyList: List<MedicineInfoTimeBody>): List<MedicineInfoTime>
    fun toWeightModel(weightBody: WeightBody): Weight
    fun toPressureModel(pressureBody: PressureBody): Pressure
    fun toArticleModelList(articleBodyList: ArticleBodyList): List<Article>
}

class ConverterBMImpl : ConverterBM {
    override fun toUserModelList(userBodyToGet: UserBodyToGet): User {
        return User(
            id = userBodyToGet.id,
            email = userBodyToGet.email,
            phoneNumber = userBodyToGet.phone_number,
            firstName = userBodyToGet.first_name,
            lastName = userBodyToGet.last_name,
            roleId = userBodyToGet.roleId,
        )
    }

    override fun toUserParameterModel(userParameterBody: UserParameterBody): UserParameter {
        return UserParameter(
            id = userParameterBody.id,
            age = userParameterBody.age,
            height = userParameterBody.height,
            weight = userParameterBody.weight,
            waist = userParameterBody.waist,
            userId = userParameterBody.userId,
            genderId = userParameterBody.genderId,
        )
    }

    override fun toRatingModelList(ratingBodyList: List<RatingBody>): List<Rating> {
        val result = ArrayList<Rating>()
        ratingBodyList.forEach {
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

    override fun toUserFavoriteArticleModel(userFavoriteArticleBody: UserFavoriteArticleBody): UserFavoriteArticle {
        return UserFavoriteArticle(
            id = userFavoriteArticleBody.id,
            userId = userFavoriteArticleBody.userId,
        )
    }

    override fun toDreamModelList(dreamBodyList: List<DreamBody>): List<Dream> {
        val result = ArrayList<Dream>()
        dreamBodyList.forEach {
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

    override fun toDreamInfoModelList(dreamInfoBodyList: List<DreamInfoBody>): List<DreamInfo> {
        val result = ArrayList<DreamInfo>()
        dreamInfoBodyList.forEach {
            val converted = DreamInfo(
                id = it.id,
                note = it.note,
                dreamId = it.dreamId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toPhysicalConditionModelList(physicalConditionBodyList: List<PhysicalConditionBody>): List<PhysicalCondition> {
        val result = ArrayList<PhysicalCondition>()
        physicalConditionBodyList.forEach {
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

    override fun toPhysicalInfoModelList(physicalInfoBodyList: List<PhysicalInfoBody>): List<PhysicalInfo> {
        val result = ArrayList<PhysicalInfo>()
        physicalInfoBodyList.forEach {
            val converted = PhysicalInfo(
                id = it.id,
                note = it.note,
                physicalConditionId = it.physicalConditionId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toMentalConditionModelList(mentalConditionBodyList: List<MentalConditionBody>): List<MentalCondition> {
        val result = ArrayList<MentalCondition>()
        mentalConditionBodyList.forEach {
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

    override fun toMentalInfoModelList(mentalInfoBodyList: List<MentalInfoBody>): List<MentalInfo> {
        val result = ArrayList<MentalInfo>()
        mentalInfoBodyList.forEach {
            val converted = MentalInfo(
                id = it.id,
                note = it.note,
                mentalConditionId = it.mentalConditionId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toWaterModel(waterBody: WaterBody): Water {
        return Water(
            id = waterBody.id,
            mode = waterBody.mode,
            periodicity = waterBody.periodicity,
            userId = waterBody.userId,
        )
    }

    override fun toFoodModel(foodBody: FoodBody): Food {
        return Food(
            id = foodBody.id,
            mode = foodBody.mode,
            time1 = foodBody.time1,
            time1_mode = foodBody.time1_mode,
            time2 = foodBody.time2,
            time2_mode = foodBody.time2_mode,
            time3 = foodBody.time3,
            time3_mode = foodBody.time3_mode,
            time4 = foodBody.time4,
            time4_mode = foodBody.time4_mode,
            time5 = foodBody.time5,
            time5_mode = foodBody.time5_mode,
            userId = foodBody.userId,
        )
    }

    override fun toMedicineModel(medicineBody: MedicineBody): Medicine {
        return Medicine(
            id = medicineBody.id,
            mode = medicineBody.mode,
            userId = medicineBody.userId,
        )
    }

    override fun toMedicineInfoModelList(medicineInfoBodyList: List<MedicineInfoBody>): List<MedicineInfo> {
        val result = ArrayList<MedicineInfo>()
        medicineInfoBodyList.forEach {
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

    override fun toMedicineInfoTimeModelList(medicineInfoTimeBodyList: List<MedicineInfoTimeBody>): List<MedicineInfoTime> {
        val result = ArrayList<MedicineInfoTime>()
        medicineInfoTimeBodyList.forEach {
            val converted = MedicineInfoTime(
                id = it.id,
                time = it.time,
                medicineInfoId = it.medicineInfoId,
            )
            result.add(converted)
        }
        return result
    }

    override fun toWeightModel(weightBody: WeightBody): Weight {
        return Weight(
            id = weightBody.id,
            mode = weightBody.mode,
            monday = weightBody.monday,
            tuesday = weightBody.tuesday,
            wednesday = weightBody.wednesday,
            thursday = weightBody.thursday,
            friday = weightBody.friday,
            saturday = weightBody.saturday,
            sunday = weightBody.sunday,
            time = weightBody.time,
            userId = weightBody.userId,
        )
    }

    override fun toPressureModel(pressureBody: PressureBody): Pressure {
        return Pressure(
            id = pressureBody.id,
            mode = pressureBody.mode,
            time1 = pressureBody.time1,
            time1_mode = pressureBody.time1_mode,
            time2 = pressureBody.time2,
            time2_mode = pressureBody.time2_mode,
            time3 = pressureBody.time3,
            time3_mode = pressureBody.time3_mode,
            userId = pressureBody.userId,
        )
    }

    override fun toArticleModelList(articleBodyList: ArticleBodyList): List<Article> {
        val result = ArrayList<Article>()
        articleBodyList.rows.forEach {
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