package com.chatserver.dd.chat.blocks.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelChatActivity(private val eventManager: UIEventManager) : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getChat()
        emit(receivedData)
    }

    fun getData() = liveData {
        eventManager.viewProgressBar()
        val receivedData = repository.getChat()
        eventManager.viewToast("Updated")
        eventManager.stopProgressBar()
        emit(receivedData)
    }

    fun sendMessage(messageToSend: String) = liveData {
        val receivedData = repository.sendMessage("amx_say !tADMIN: !g$messageToSend")

        emit(receivedData)
    }
}