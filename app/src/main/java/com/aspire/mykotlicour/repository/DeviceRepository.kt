package com.aspire.mykotlicour.repository

import com.aspire.mykotlicour.apicommon.ApiService
import com.aspire.mykotlicour.model.Device
import retrofit2.Response
import javax.inject.Inject

class DeviceRepository @Inject constructor(private val apiService: ApiService) {

    fun authenticate(username : String, password: String) : Boolean{
        //if (username == "admin" && password == "password") {
           return true
//        } else {
//           return false
//        }
    }

    suspend fun getPosts(): Response<List<Device>> = apiService.getAllDevices()

    suspend fun saveDevice(device: Device): Response<Device> = apiService.saveDevice(device)



}