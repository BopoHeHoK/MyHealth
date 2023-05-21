package com.test.myhealth.app.presentation.screen.signin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auth0.android.jwt.JWT
import com.test.myhealth.data.api.RetrofitInstance
import com.test.myhealth.data.storage.modelApi.LoginBody
import com.test.myhealth.data.storage.modelApi.TokenBody
import com.test.myhealth.domain.model.Login
import com.test.myhealth.domain.useCase.GetUserIdFromSharedPrefsUseCase
import com.test.myhealth.domain.useCase.SetUserIdToSharedPrefsUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingInViewModel(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase
) : ViewModel() {

    val tokenLiveData = MutableLiveData<String>()

    private fun loginToData(login: Login): LoginBody {
        return LoginBody(
            email = login.email,
            password = login.password
        )
    }

    fun getToken(login: Login) {
        RetrofitInstance.api.postLogin(loginToData(login)).enqueue(object : Callback<TokenBody> {
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