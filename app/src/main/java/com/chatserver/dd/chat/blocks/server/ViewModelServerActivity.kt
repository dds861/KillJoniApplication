package com.chatserver.dd.chat.blocks.server

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelServerActivity : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getServer()
        emit(receivedData)
    }
}