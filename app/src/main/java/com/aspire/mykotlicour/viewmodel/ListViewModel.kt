package com.aspire.mykotlicour.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aspire.mykotlicour.model.DeleteResp
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
    private val _deviceDeleteResp = MutableLiveData<Response<DeleteResp>>()
    val deviceDeleteResp: LiveData<Response<DeleteResp>> get() = _deviceDeleteResp



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

    fun deleteItem(item: Device) {
        viewModelScope.launch {
            var response = loginRepository.deleteDevice(item)
            //if(response.isSuccessful) {
                _deviceDeleteResp.value = response
                Log.e("Susan", "delete" + response.body().toString())
//            }else{
//                Log.e("Susan", "not deleted" + response.body()!!.error)
//            }
        }

    }

}