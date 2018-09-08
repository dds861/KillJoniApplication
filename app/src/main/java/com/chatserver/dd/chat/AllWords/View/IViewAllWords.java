package com.chatserver.dd.chat.AllWords.View;

import java.util.List;

public interface IViewAllWords {

    void setDataToRecyclerView(List<UsersAllWords> userList);
    void onResponseFailure(Throwable throwable);
}
