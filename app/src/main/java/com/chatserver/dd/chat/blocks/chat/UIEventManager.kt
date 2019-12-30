package com.chatserver.dd.chat.blocks.chat

interface UIEventManager {

    fun viewProgressBar()
    fun stopProgressBar()
    fun viewToast(s: String)

}