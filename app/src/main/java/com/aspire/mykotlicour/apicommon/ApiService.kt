package com.aspire.mykotlicour.apicommon

import com.aspire.mykotlicour.model.Device
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("objects")
    suspend fun getAllDevices(): Response<List<Device>>

    @POST("objects")
    suspend fun saveDevice(@Body device: Device): Response<Device>
}