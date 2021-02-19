package com.chatserver.dd.chat.Cmd.View

import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers.P

interface IViewCmd {
    fun onResponseFailure(throwable: Throwable?)
    var edittext: String?
    fun showToast(text: String?)
    fun showProgressBar()
    fun hideProgressBar()
    fun listIsEmpty()
    fun listIsNotEmpty()
    fun setDataToRecyclerView(sorted: List<P?>)
}