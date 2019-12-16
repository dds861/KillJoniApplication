package com.chatserver.dd.chat.allwords.model;

import com.chatserver.dd.chat.allwords.view.UsersAllWords;

import java.util.List;

public interface IModelAllWords {
    void  getArrayList(OnFinishedListener onFinishedListener);

    interface OnFinishedListener {
        void onFinished(List<UsersAllWords> arrayList);
        void onFailure(Throwable t);
    }


}
