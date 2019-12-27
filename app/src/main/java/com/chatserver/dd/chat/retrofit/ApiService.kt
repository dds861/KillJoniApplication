package com.chatserver.dd.chat.retrofit

import com.chatserver.dd.chat.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("hlstats_Events_AllWords.php")
    suspend fun getChat(): List<Chat>

    @GET("hlstats_Events_adminConnect.php")
    suspend fun getAdmin(): List<Admin>

    @GET("hlstats_Events_ServerWords.php")
    suspend fun getServer(): List<Server>

    @GET("hlstats_Events_VipWords.php")
    suspend fun getVip(): List<Vip>

    //url for myarena Status
    @GET("api.php")
    suspend fun getUserData(
            @Query("query") query: String,
            @Query("token") token: String
    ): Status

    @GET("api.php")
    suspend fun getStatus(
            @Query("query") query: String,
            @Query("token") token: String
    ): Status

    //kick
    @GET("api.php")
    suspend fun getConsoleCmd(
            @Query("query") query: String,
            @Query("cmd") cmd: String,
            @Query("token") token: String
    ): Status

    //Start
    @GET("api.php")
    suspend fun getServerActions(
            @Query("query") query: String,
            @Query("token") token: String
    ): Status

}