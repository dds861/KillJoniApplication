package com.chatserver.dd.chat.blocks.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelChatActivityFactory(private val eventManager: UIEventManager) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelChatActivity::class.java)) {
            return ViewModelChatActivity(eventManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}