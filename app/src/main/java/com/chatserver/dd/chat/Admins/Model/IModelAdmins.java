package com.chatserver.dd.chat.Admins.Model;

import com.chatserver.dd.chat.Admins.View.UsersAdmins;

import java.util.List;

public interface IModelAdmins {
    void  getArrayList(OnFinishedListener onFinishedListener);

    interface OnFinishedListener {
        void resultsOnRequest(List<UsersAdmins> arrayList);
        void onFailure(Throwable t);
    }
}
