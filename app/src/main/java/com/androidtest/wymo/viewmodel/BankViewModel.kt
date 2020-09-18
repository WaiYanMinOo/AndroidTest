package com.androidtest.wymo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.androidtest.wymo.repository.Repository

class BankViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Repository(application)

    fun getBankList() = repository.getAllBankList()
}