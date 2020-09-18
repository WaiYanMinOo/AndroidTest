package com.androidtest.wymo.network

import com.androidtest.wymo.model.DataResponseModel
import com.androidtest.wymo.util.AppConstant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @Headers(AppConstant.APP_ID,AppConstant.SECRET_KEY)
    @GET("api/banks")
    fun getBankList(): Call<DataResponseModel>
}