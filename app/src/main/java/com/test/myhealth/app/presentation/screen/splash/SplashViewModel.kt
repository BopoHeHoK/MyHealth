package com.test.myhealth.app.presentation.screen.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myhealth.data.api.RetrofitInstance
import com.test.myhealth.data.storage.converters.ConverterBM
import com.test.myhealth.data.storage.modelApi.*
import com.test.myhealth.domain.model.*
import com.test.myhealth.domain.useCase.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashViewModel(
    private val converterBM: ConverterBM,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val saveRoleToDbUseCase: SaveRoleToDbUseCase,
    private val saveGenderToDbUseCase: SaveGenderToDbUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
    private val saveUserParameterToDbUseCase: SaveUserParameterToDbUseCase,
    private val saveRatingToDbUseCase: SaveRatingToDbUseCase,
    private val saveUserFavoriteArticleToDbUseCase: SaveUserFavoriteArticleToDbUseCase,
    private val saveDreamToDbUseCase: SaveDreamToDbUseCase,
    private val saveDreamInfoToDbUseCase: SaveDreamInfoToDbUseCase,
    private val savePhysicalConditionToDbUseCase: SavePhysicalConditionToDbUseCase,
    private val savePhysicalInfoToDbUseCase: SavePhysicalInfoToDbUseCase,
    private val saveMentalConditionToDbUseCase: SaveMentalConditionToDbUseCase,
    private val saveMentalInfoToDbUseCase: SaveMentalInfoUserToDbUseCase,
    private val saveWaterToDbUseCase: SaveWaterToDbUseCase,
    private val saveFoodToDbUseCase: SaveFoodToDbUseCase,
    private val saveMedicineToDbUseCase: SaveMedicineToDbUseCase,
    private val saveMedicineInfoToDbUseCase: SaveMedicineInfoToDbUseCase,
    private val saveMedicineInfoTimeToDbUseCase: SaveMedicineInfoTimeToDbUseCase,
    private val saveWeightToDbUseCase: SaveWeightToDbUseCase,
    private val savePressureToDbUseCase: SavePressureToDbUseCase,
    private val saveArticlesToDbUseCase: SaveArticlesToDbUseCase,
) : ViewModel() {

    val userLiveData = MutableLiveData<User>()
    val userParameterLiveData = MutableLiveData<UserParameter>()
    val ratingLiveData = MutableLiveData<List<Rating>>()
    val userFavoriteArticleLiveData = MutableLiveData<UserFavoriteArticle>()
    val dreamLiveData = MutableLiveData<List<Dream>>()
    val dreamInfoLiveData = MutableLiveData<List<DreamInfo>>()
    val physicalConditionLiveData = MutableLiveData<List<PhysicalCondition>>()
    val physicalInfoLiveData = MutableLiveData<List<PhysicalInfo>>()
    val mentalConditionLiveData = MutableLiveData<List<MentalCondition>>()
    val mentalInfoLiveData = MutableLiveData<List<MentalInfo>>()
    val waterLiveData = MutableLiveData<Water>()
    val foodLiveData = MutableLiveData<Food>()
    val medicineLiveData = MutableLiveData<Medicine>()
    val medicineInfoLiveData = MutableLiveData<List<MedicineInfo>>()
    val medicineInfoTimeLiveData = MutableLiveData<List<MedicineInfoTime>>()
    val weightLiveData = MutableLiveData<Weight>()
    val pressureLiveData = MutableLiveData<Pressure>()
    val articleLiveData = MutableLiveData<List<Article>>()

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getUser(id: Long) {
        RetrofitInstance.api.getUser(id).enqueue(object : Callback<UserBodyToGet> {
            override fun onResponse(call: Call<UserBodyToGet>, response: Response<UserBodyToGet>) {
                response.body()?.let { user ->
                    userLiveData.value = converterBM.toUserModelList(user)
                    userParameterLiveData.value =
                        converterBM.toUserParameterModel(user.userParameter)
                    ratingLiveData.value = converterBM.toRatingModelList(user.rating)
                    userFavoriteArticleLiveData.value =
                        converterBM.toUserFavoriteArticleModel(user.userFavoriteArticle)
                    dreamLiveData.value = converterBM.toDreamModelList(user.dream)
                    user.dream.forEach { dreamBody ->
                        dreamInfoLiveData.value =
                            converterBM.toDreamInfoModelList(dreamBody.dreamInfo)
                    }
                    physicalConditionLiveData.value =
                        converterBM.toPhysicalConditionModelList(user.physicalCondition)
                    user.physicalCondition.forEach { physicalConditionBody ->
                        physicalInfoLiveData.value =
                            converterBM.toPhysicalInfoModelList(physicalConditionBody.physicalInfo)
                    }
                    mentalConditionLiveData.value =
                        converterBM.toMentalConditionModelList(user.mentalCondition)
                    user.mentalCondition.forEach { mentalConditionBody ->
                        mentalInfoLiveData.value =
                            converterBM.toMentalInfoModelList(mentalConditionBody.mentalInfo)
                    }
                    waterLiveData.value = converterBM.toWaterModel(user.water)
                    foodLiveData.value = converterBM.toFoodModel(user.food)
                    medicineLiveData.value = converterBM.toMedicineModel(user.medicine)
                    medicineInfoLiveData.value =
                        converterBM.toMedicineInfoModelList(user.medicine.medicineInfo)
                    user.medicine.medicineInfo.forEach { medicineInfo ->
                        medicineInfoTimeLiveData.value =
                            converterBM.toMedicineInfoTimeModelList(medicineInfo.medicineInfoTime)
                    }
                    weightLiveData.value = converterBM.toWeightModel(user.weight)
                    pressureLiveData.value = converterBM.toPressureModel(user.pressure)
                }
            }

            override fun onFailure(call: Call<UserBodyToGet>, t: Throwable) {
                Log.e("apiError", t.message.toString())
            }
        })
    }

    fun getArticles() {
        RetrofitInstance.api.getArticle().enqueue(object : Callback<ArticleBodyList> {
            override fun onResponse(
                call: Call<ArticleBodyList>,
                response: Response<ArticleBodyList>
            ) {
                response.body()?.let { articleList ->
                    articleLiveData.value = converterBM.toArticleModelList(articleList)
                }
            }

            override fun onFailure(call: Call<ArticleBodyList>, t: Throwable) {
                Log.e("apiError", t.message.toString())
            }

        })
    }

    fun observerUser(): LiveData<User> {
        return userLiveData
    }

    fun observerUserParameter(): LiveData<UserParameter> {
        return userParameterLiveData
    }

    fun observerRating(): LiveData<List<Rating>> {
        return ratingLiveData
    }

    fun observerUserFavoriteArticle(): LiveData<UserFavoriteArticle> {
        return userFavoriteArticleLiveData
    }

    fun observerDream(): LiveData<List<Dream>> {
        return dreamLiveData
    }

    fun observerDreamInfo(): LiveData<List<DreamInfo>> {
        return dreamInfoLiveData
    }

    fun observerPhysicalCondition(): LiveData<List<PhysicalCondition>> {
        return physicalConditionLiveData
    }

    fun observerPhysicalInfo(): LiveData<List<PhysicalInfo>> {
        return physicalInfoLiveData
    }

    fun observerMentalCondition(): LiveData<List<MentalCondition>> {
        return mentalConditionLiveData
    }

    fun observerMentalInfo(): LiveData<List<MentalInfo>> {
        return mentalInfoLiveData
    }

    fun observerWater(): LiveData<Water> {
        return waterLiveData
    }

    fun observerFood(): LiveData<Food> {
        return foodLiveData
    }

    fun observerMedicine(): LiveData<Medicine> {
        return medicineLiveData
    }

    fun observerMedicineInfo(): LiveData<List<MedicineInfo>> {
        return medicineInfoLiveData
    }

    fun observerMedicineInfoTime(): LiveData<List<MedicineInfoTime>> {
        return medicineInfoTimeLiveData
    }

    fun observerWeight(): LiveData<Weight> {
        return weightLiveData
    }

    fun observerPressure(): LiveData<Pressure> {
        return pressureLiveData
    }

    fun observerArticles(): LiveData<List<Article>> {
        return articleLiveData
    }

    fun upsertRole(role: Role) {
        viewModelScope.launch {
            saveRoleToDbUseCase.execute(role = role)
        }
    }

    fun upsertGender(gender: Gender) {
        viewModelScope.launch {
            saveGenderToDbUseCase.execute(gender = gender)
        }
    }

    fun upsertUser(user: User) {
        viewModelScope.launch {
            saveUserToDbUseCase.execute(user = user)
        }
    }

    fun upsertUserParameter(userParameter: UserParameter) {
        viewModelScope.launch {
            saveUserParameterToDbUseCase.execute(userParameter = userParameter)
        }
    }

    fun upsertRating(rating: Rating) {
        viewModelScope.launch {
            saveRatingToDbUseCase.execute(rating = rating)
        }
    }

    fun upsertUserFavoriteArticle(userFavoriteArticle: UserFavoriteArticle) {
        viewModelScope.launch {
            saveUserFavoriteArticleToDbUseCase.execute(userFavoriteArticle = userFavoriteArticle)
        }
    }

    fun upsertDream(dream: Dream) {
        viewModelScope.launch {
            saveDreamToDbUseCase.execute(dream = dream)
        }
    }

    fun upsertDreamInfo(dreamInfo: DreamInfo) {
        viewModelScope.launch {
            saveDreamInfoToDbUseCase.execute(dreamInfo = dreamInfo)
        }
    }

    fun upsertPhysicalCondition(physicalCondition: PhysicalCondition) {
        viewModelScope.launch {
            savePhysicalConditionToDbUseCase.execute(physicalCondition = physicalCondition)
        }
    }

    fun upsertPhysicalInfo(physicalInfo: PhysicalInfo) {
        viewModelScope.launch {
            savePhysicalInfoToDbUseCase.execute(physicalInfo = physicalInfo)
        }
    }

    fun upsertMentalCondition(mentalCondition: MentalCondition) {
        viewModelScope.launch {
            saveMentalConditionToDbUseCase.execute(mentalCondition = mentalCondition)
        }
    }

    fun upsertMentalInfo(mentalInfo: MentalInfo) {
        viewModelScope.launch {
            saveMentalInfoToDbUseCase.execute(mentalInfo = mentalInfo)
        }
    }

    fun upsertWater(water: Water) {
        viewModelScope.launch {
            saveWaterToDbUseCase.execute(water = water)
        }
    }

    fun upsertFood(food: Food) {
        viewModelScope.launch {
            saveFoodToDbUseCase.execute(food = food)
        }
    }

    fun upsertMedicine(medicine: Medicine) {
        viewModelScope.launch {
            saveMedicineToDbUseCase.execute(medicine = medicine)
        }
    }

    fun upsertMedicineInfo(medicineInfo: MedicineInfo) {
        viewModelScope.launch {
            saveMedicineInfoToDbUseCase.execute(medicineInfo = medicineInfo)
        }

    }

    fun upsertMedicineInfoTime(medicineInfoTime: MedicineInfoTime) {
        viewModelScope.launch {
            saveMedicineInfoTimeToDbUseCase.execute(medicineInfoTime = medicineInfoTime)
        }
    }

    fun upsertWeight(weight: Weight) {
        viewModelScope.launch {
            saveWeightToDbUseCase.execute(weight = weight)
        }
    }

    fun upsertPressure(pressure: Pressure) {
        viewModelScope.launch {
            savePressureToDbUseCase.execute(pressure = pressure)
        }
    }

    fun upsertArticles(article: Article) {
        viewModelScope.launch {
            saveArticlesToDbUseCase.execute(article = article)
        }
    }
}