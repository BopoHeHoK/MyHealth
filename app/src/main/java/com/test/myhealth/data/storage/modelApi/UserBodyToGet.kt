package com.test.myhealth.data.storage.modelApi

data class UserBodyToGet(
    val id: Long,
    val email: String?,
    val phoneNumber: String?,
    val firstName: String?,
    val lastName: String?,
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