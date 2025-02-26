package com.aspire.mykotlicour.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aspire.mykotlicour.model.Device
import com.aspire.mykotlicour.repository.DeviceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: DeviceRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult
   // @Inject lateinit var loginRepository: LoginRepository

    fun login(username: String, password: String) {
//        if (username == "admin" && password == "password") {
//            _loginResult.value = true
//        } else {
//            _loginResult.value = false
//        }
        var result = loginRepository.authenticate(username, password)
        if(result)
            _loginResult.value = true
         else
            _loginResult.value = false

    }

}