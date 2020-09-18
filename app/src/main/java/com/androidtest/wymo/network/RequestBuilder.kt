package com.androidtest.wymo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestBuilder {
    private lateinit var retrofit: Retrofit
    private lateinit var builder: Retrofit.Builder

    fun <S> createService(serviceClass: Class<S>, baseUrl: String): S {
        builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
        retrofit = builder.build()
        return retrofit.create(serviceClass)
    }
}