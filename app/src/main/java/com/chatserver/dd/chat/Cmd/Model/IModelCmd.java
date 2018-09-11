package com.chatserver.dd.chat.Cmd.Model;

import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd;
import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers;

public interface IModelCmd {
    void getPlayersList(OnFinishedListener onFinishedListener);
    interface OnFinishedListener {
        void onFinishedPlayers(ViewStatusPlayers viewStatusPlayers);
        void onFailurePlayers(Throwable t);
    }

    void onExecuteCmd(OnFinishedListenerCmd onFinishedListenerCmd,String cmdCommand);
    interface OnFinishedListenerCmd {
        void onFinishedCmd(ViewConsoleCmd viewConsoleCmd);
        void onFailureCmd(Throwable t);
    }
}
