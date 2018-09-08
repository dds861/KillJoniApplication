package com.chatserver.dd.chat.Vip.Model;

import com.chatserver.dd.chat.Vip.View.UsersVip;

import java.util.List;

public interface IModel {
    void  getArrayList(OnFinishedListener onFinishedListener);

    interface OnFinishedListener {
        void onFinished(List<UsersVip> arrayList);
        void onFailure(Throwable t);
    }
}
