package com.chatserver.dd.chat.blocks.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelAdminActivity : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getAdmin()
        emit(receivedData)
    }
}