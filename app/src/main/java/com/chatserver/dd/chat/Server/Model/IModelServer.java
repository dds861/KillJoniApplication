package com.chatserver.dd.chat.Server.Model;


import com.chatserver.dd.chat.Server.View.UsersServer;

import java.util.List;

public interface IModelServer {
    void  getArrayList(OnFinishedListener onFinishedListener);

    interface OnFinishedListener {
        void onFinished(List<UsersServer> arrayList);
        void onFailure(Throwable t);
    }
}
