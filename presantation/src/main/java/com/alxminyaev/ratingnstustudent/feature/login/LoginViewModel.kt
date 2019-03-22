package com.alxminyaev.ratingnstustudent.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var username: String = ""
    var password: String = ""
    val message: MutableLiveData<String> = MutableLiveData()

    fun singIn() {
    }

}
