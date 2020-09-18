package com.androidtest.wymo.util

import com.androidtest.wymo.BuildConfig

object AppConstant {
    const val BASE_URL = "https://dev.meemee.online/"
    const val APP_ID = "app-id: ${BuildConfig.ID}"
    const val SECRET_KEY = "secret-key: ${BuildConfig.KEY}"
}