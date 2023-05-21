package com.test.myhealth.data.storage.modelApi

data class UserBodyToGet(
    val id: Long,
    val email: String?,
    val phone_number: String?,
    val first_name: String?,
    val last_name: String?,
    val roleId: Long,
    val userParameter: UserParameterBody,
    val rating: List<RatingBody>,
    val userFavoriteArticle: UserFavoriteArticleBody,
    val dream: List<DreamBody>,
    val physicalCondition: List<PhysicalConditionBody>,
    val mentalCondition: List<MentalConditionBody>,
    val water: WaterBody,
    val food: FoodBody,
    val medicine: MedicineBody,
    val weight: WeightBody,
    val pressure: PressureBody,
    val createdAt: String,
    val updatedAt: String,
)