package com.chatserver.dd.chat.Server.View;

import java.util.List;

public interface IViewServer {

    void setDataToRecyclerView(List<UsersServer> userList);
    void onResponseFailure(Throwable throwable);
}
