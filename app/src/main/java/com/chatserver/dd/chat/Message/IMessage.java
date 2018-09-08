package com.chatserver.dd.chat.Message;

import java.util.List;

public interface IMessage {

    interface IMessageView {

        void setPlayersList();

    }
    interface IMessagePresenter {

        void onPlayerClicked(int adapterPosition, String namePlayer);
    }

    interface IMessageModel {

        List<String> getPlayersList();
    }
}
