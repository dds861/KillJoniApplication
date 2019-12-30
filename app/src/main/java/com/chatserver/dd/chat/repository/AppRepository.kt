package com.chatserver.dd.chat.repository

import com.chatserver.dd.chat.constants.ConstantsApp
import com.chatserver.dd.chat.model.*
import com.chatserver.dd.chat.retrofit.ApiService
import com.chatserver.dd.chat.retrofit.RetrofitInstance

class AppRepository {
    var service: ApiService = RetrofitInstance.appService
    var serviceMyArena: ApiService = RetrofitInstance.appServiceMyArena

    suspend fun getChat(): List<Chat> = service.getChat()

    suspend fun getAdmin(): List<Admin> = service.getAdmin()

    suspend fun getVip(): List<Vip> = service.getVip()

    suspend fun getServer(): List<Server> = service.getServer()

    suspend fun getStatus(): Status = serviceMyArena.getStatus(
            ConstantsApp.STATUS,
            ConstantsApp.TOKEN_MYARENA
    )

    suspend fun sendMessage(messageToSend: String): ConsoleResponse = serviceMyArena.executeСonsoleСommand(
            ConstantsApp.QUERY,
            messageToSend,
            ConstantsApp.TOKEN_MYARENA
    )
}