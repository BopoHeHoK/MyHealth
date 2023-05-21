package com.test.myhealth.app.presentation.screen.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auth0.android.jwt.JWT
import com.test.myhealth.data.api.RetrofitInstance
import com.test.myhealth.data.storage.modelApi.RegisterBody
import com.test.myhealth.data.storage.modelApi.TokenBody
import com.test.myhealth.domain.model.Register
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.SetUserIdToSharedPrefsUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingUpViewModel(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase
) : ViewModel() {

    private var tokenLiveData = MutableLiveData<String>()

    private fun registerToData(register: Register): RegisterBody {
        return RegisterBody(
            email = register.email,
            first_name = register.first_name,
            last_name = register.last_name,
            password = register.password
        )
    }

    fun getToken(register: Register) {
        RetrofitInstance.api.postRegistration(registerToData(register))
            .enqueue(object : Callback<TokenBody> {
                override fun onResponse(call: Call<TokenBody>, response: Response<TokenBody>) {
                    response.body()?.let { token ->
                        tokenLiveData.value = token.token
                    }
                }

                override fun onFailure(call: Call<TokenBody>, t: Throwable) {
                    Log.e("apiError", t.message.toString())
                }
            })
    }

    fun observerToken(): LiveData<String> {
        return tokenLiveData
    }

    fun setUserId() {
        val parsedJWT = tokenLiveData.value?.let { JWT(it) }
        val subscriptionMetaData = parsedJWT?.getClaim("id")
        val parsedValue = subscriptionMetaData?.asString()
        if (parsedValue == null) {
            setUserIdToSharedPrefsUseCase.execute(0L)
        } else {
            setUserIdToSharedPrefsUseCase.execute(parsedValue.toLong())
        }
    }

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }
}