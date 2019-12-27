package com.chatserver.dd.chat.blocks.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelChatActivity : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getChat()
        emit(receivedData)
    }
}