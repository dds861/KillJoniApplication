package com.chatserver.dd.chat.blocks.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelPlayersActivity : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getStatus()
        emit(receivedData)
    }
}