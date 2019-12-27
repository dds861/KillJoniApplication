package com.chatserver.dd.chat.model
import com.google.gson.annotations.SerializedName


data class Admin(
    @SerializedName("eventTime")
    val eventTime: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("0")
    val x0: String,
    @SerializedName("1")
    val x1: String,
    @SerializedName("2")
    val x2: String,
    @SerializedName("3")
    val x3: String
)