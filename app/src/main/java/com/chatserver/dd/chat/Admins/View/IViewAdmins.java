package com.chatserver.dd.chat.Admins.View;

import java.util.List;

public interface IViewAdmins {

    void setDataToRecyclerView(List<UsersAdmins> userList);
    void onResponseFailure(Throwable throwable);
}
