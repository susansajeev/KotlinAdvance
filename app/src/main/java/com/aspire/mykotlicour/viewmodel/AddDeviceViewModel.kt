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
class AddDeviceViewModel @Inject constructor(private val deviceRepository: DeviceRepository) : ViewModel() {

    private val _deviceResp = MutableLiveData<Response<Device>>()
    val deviceResp: LiveData<Response<Device>> get() = _deviceResp

    fun saveDevice(device: Device){
        viewModelScope.launch {
            var resp =  deviceRepository.saveDevice(device)
            _deviceResp.value = resp
            Log.e("Susan","11"+ _deviceResp.value!!.body().toString())

        }

    }
}