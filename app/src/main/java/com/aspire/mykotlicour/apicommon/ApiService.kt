package com.aspire.mykotlicour.apicommon

import com.aspire.mykotlicour.model.DeleteResp
import com.aspire.mykotlicour.model.Device
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("objects")
    suspend fun getAllDevices(): Response<List<Device>>

    @POST("objects")
    suspend fun saveDevice(@Body device: Device): Response<Device>

    @DELETE("objects/{id}")
    suspend fun deleteDevice(@Path("id") id: String): Response<DeleteResp>
}