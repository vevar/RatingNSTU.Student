package com.alxminyaev.ratingnstustudent.feature.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alxminyaev.ratingnstustudent.domain.model.Student
import com.alxminyaev.ratingnstustudent.domain.usecase.auth.AuthUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    var username: String = ""
    var password: String = ""
    val message: ObservableField<String> = ObservableField()
    val student: MutableLiveData<Student> = MutableLiveData()
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    @Inject
    lateinit var authUseCase: AuthUseCase

    fun singIn() {
        launchDataLoad {
            student.value = withContext(Dispatchers.IO) {
                delay(3_000)
                Student(0)
            }
        }
    }


    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _isLoading.value = true
                block()
            } catch (error: LoginError) {

            } finally {
                _isLoading.value = false
            }
        }
    }
}

class LoginError(cause: Throwable) : Throwable(cause.message, cause)