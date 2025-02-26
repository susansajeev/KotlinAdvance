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
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val loginRepository: DeviceRepository) : ViewModel()  {

    private val _deviceResp = MutableLiveData<Response<List<Device>>>()
    val deviceResp: LiveData<Response<List<Device>>> get() = _deviceResp



    init {
        getDeviceList()
    }

    fun getDeviceList(){
        viewModelScope.launch {
            var response = loginRepository.getPosts()
            _deviceResp.value = response
            Log.e("Susan","11"+ _deviceResp.value!!.body().toString())
        }
    }

}