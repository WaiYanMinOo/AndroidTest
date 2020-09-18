package com.androidtest.wymo.model

data class DataResponseModel(
    val code: Int,
    val data: List<Data>,
    val message: String
)