package com.test.myhealth.data.api

import com.test.myhealth.data.storage.modelApi.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyHealthAPI {

    //AUTHORIZATION//

    @POST("user/login")
    fun postLogin(
        @Body login: LoginBody
    ): Call<TokenBody>

    @POST("user/registration")
    fun postRegistration(
        @Body register: RegisterBody
    ): Call<TokenBody>

    @GET("user/auth")
    fun getAuth(@Header("Authorization") authToken: String?): Call<ResponseBody>

    //AUTHORIZATION//

    //ARTICLES//

    @GET("article")
    fun getArticle(): Call<ArticleBodyList>

    //ARTICLES//

    //USER//

    @GET("user/{id}")
    fun getUser(@Path("id") id: Long): Call<UserBodyToGet>

    @PATCH("user/{id}")
    fun updateUser(
        @Body user: UserBodyToGet
    ): Call<UserBodyToGet>

    //USER//
}