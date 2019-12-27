package com.chatserver.dd.chat.blocks.vip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository

class ViewModelVipActivity : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        val receivedData = repository.getVip()
        emit(receivedData)
    }
}