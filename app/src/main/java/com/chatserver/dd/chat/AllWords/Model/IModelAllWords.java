package com.chatserver.dd.chat.AllWords.Model;

import com.chatserver.dd.chat.AllWords.View.UsersAllWords;

import java.util.List;

public interface IModelAllWords {
    void  getArrayList(OnFinishedListener onFinishedListener);

    interface OnFinishedListener {
        void onFinished(List<UsersAllWords> arrayList);
        void onFailure(Throwable t);
    }
}
