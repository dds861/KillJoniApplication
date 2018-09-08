package com.chatserver.dd.chat.Message.Presenter;

import com.chatserver.dd.chat.Message.IMessage;

public class MessagePresenter implements IMessage.IMessagePresenter {

    IMessage.IMessageView iMessageView;

    public MessagePresenter(IMessage.IMessageView iMessageView) {
        this.iMessageView = iMessageView;
    }

    @Override
    public void onPlayerClicked(int adapterPosition, String namePlayer) {

    }
}
