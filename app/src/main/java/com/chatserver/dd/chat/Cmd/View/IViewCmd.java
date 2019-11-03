package com.chatserver.dd.chat.Cmd.View;

public interface IViewCmd {

    void setDataToRecyclerView(ViewStatusPlayers dataToRecyclerView);
    void onResponseFailure(Throwable throwable);
    void setEdittext(String playerName);
    String getEdittext();
    void showToast(String text);

    void showProgressBar();

    void hideProgressBar();

    void listIsEmpty();

    void listIsNotEmpty();
}
