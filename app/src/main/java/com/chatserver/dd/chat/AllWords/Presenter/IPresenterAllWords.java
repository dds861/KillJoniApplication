package com.chatserver.dd.chat.AllWords.Presenter;

import com.chatserver.dd.chat.AllWords.View.UsersAllWords;

import java.util.List;

public interface IPresenterAllWords {
    void requestDataFromServer();
    void onRefreshButtonClick();
}
