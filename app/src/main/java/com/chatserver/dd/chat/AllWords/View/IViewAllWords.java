package com.chatserver.dd.chat.allwords.view;

import java.util.List;

public interface IViewAllWords {

    void setDataToRecyclerView(List<UsersAllWords> userList);
    void onResponseFailure(Throwable throwable);
}
