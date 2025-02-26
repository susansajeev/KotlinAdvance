package com.aspire.mykotlicour.model

import com.google.gson.annotations.SerializedName

data class Device(

    val id: String,
    val name: String,
    val data: Data?,
    val body: String
)

data class Data(
    val color: String,
    val capacity: String,
    val year: String,
    val price: String,
    @SerializedName("CPU model") val model: String,
    @SerializedName("Hard disk size") val harDiskSize: String
)

data class DeleteResp(
    val message: String,
    val error: String,

)


