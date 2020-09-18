package com.androidtest.wymo.repository

import android.app.Application
import com.androidtest.wymo.model.DataResponseModel
import com.androidtest.wymo.network.Api
import com.androidtest.wymo.network.NetworkCall
import com.androidtest.wymo.network.RequestBuilder
import com.androidtest.wymo.util.AppConstant

class Repository(application: Application) {
    private val api = RequestBuilder.createService(Api::class.java,AppConstant.BASE_URL)

    /** get all bank list*/
    fun getAllBankList() = NetworkCall<DataResponseModel>().makeCall(api.getBankList())
}