package com.chatserver.dd.chat.Cmd.Presenter;

public interface IPresenterCmd {
    void requestDataFromServer();
    void onExecuteCmd(String cmdCommand);
    void onRefreshButtonClick();
    void onSetCmdToEditText(String playerName);
    void onSetNameToEditText(String playerName);
}
