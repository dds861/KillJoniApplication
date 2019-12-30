package com.chatserver.dd.chat.model
import com.google.gson.annotations.SerializedName


data class ConsoleResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)