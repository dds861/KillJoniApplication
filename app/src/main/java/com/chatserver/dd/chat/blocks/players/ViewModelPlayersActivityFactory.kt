package com.chatserver.dd.chat.blocks.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelPlayersActivityFactory(private val eventManager: UIEventManager) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelPlayersActivity::class.java)) {
            return ViewModelPlayersActivity(eventManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}