package com.chatserver.dd.chat.blocks.players

interface UIEventManager {
    fun viewProgressBar()
    fun stopProgressBar()
    fun viewEmptyText()
    fun stopEmptyText()
    fun viewToast(s: String)

}