package com.chatserver.dd.chat.Vip.View;

import java.util.List;

public interface IView {

    void setDataToRecyclerView(List<UsersVip> userList);
    void onResponseFailure(Throwable throwable);
}
