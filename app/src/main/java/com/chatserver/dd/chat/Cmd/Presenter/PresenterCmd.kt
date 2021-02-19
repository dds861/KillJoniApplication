package com.chatserver.dd.chat.Cmd.Presenter

import com.chatserver.dd.chat.Cmd.Model.IModelCmd
import com.chatserver.dd.chat.Cmd.Model.IModelCmd.OnFinishedListenerCmd
import com.chatserver.dd.chat.Cmd.View.IViewCmd
import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd
import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers

class PresenterCmd(var iViewCmd: IViewCmd, var iModelCmd: IModelCmd) : IPresenterCmd, IModelCmd.OnFinishedListener, OnFinishedListenerCmd {
    override fun requestDataFromServer() {
        iViewCmd.showProgressBar()
        iModelCmd.getPlayersList(this)
    }

    override fun onExecuteCmd(cmdCommand: String) {
        iModelCmd.onExecuteCmd(this, cmdCommand)
    }

    override fun onRefreshButtonClick() {
        iModelCmd.getPlayersList(this)
    }

    //replace cmd Command
    override fun onSetCmdToEditText(playerName: String) {
        //String to Array String
        val textInEdittext = iViewCmd.edittext
        val ary = textInEdittext?.split(" ".toRegex())?.toTypedArray()
        ary?.set(0, playerName)
        //array to String
        val builder = StringBuilder()
        if (ary != null) {
            for (s in ary) {
                builder.append("$s ")
            }
        }
        val str = builder.toString()
        //set string to Edittext
        iViewCmd.edittext = str
    }

    //replace playerName
    override fun onSetNameToEditText(playerName: String) {
        val textInEdittext = iViewCmd.edittext
        val ary = textInEdittext?.split(" ".toRegex())?.toTypedArray()
        iViewCmd.edittext = (ary?.get(0) ?: "") + " " + playerName
        iViewCmd.edittext = "flags_add_user \"${playerName}\" \"t\" \"+7200\" \"${playerName}\" \"FreeVip\""
    }

    override fun onFinishedPlayers(viewStatusPlayers: ViewStatusPlayers) {
        val sorted = viewStatusPlayers.data.p.sortedByDescending {
            it.time
        }

        iViewCmd.setDataToRecyclerView(sorted)
        iViewCmd.hideProgressBar()
        if (viewStatusPlayers.data.p.size > 0) {
            iViewCmd.listIsNotEmpty()
        } else {
            iViewCmd.listIsEmpty()
        }
    }

    override fun onFailurePlayers(t: Throwable) {
        iViewCmd.onResponseFailure(t)
    }

    override fun onFinishedCmd(viewConsoleCmd: ViewConsoleCmd) {
        iViewCmd.showToast(viewConsoleCmd.status)
    }

    override fun onFailureCmd(t: Throwable) {
        iViewCmd.onResponseFailure(t)
    }
}