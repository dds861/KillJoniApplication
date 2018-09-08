package com.chatserver.dd.chat.Server.Presenter;


import com.chatserver.dd.chat.Server.Model.IModelServer;
import com.chatserver.dd.chat.Server.View.IViewServer;
import com.chatserver.dd.chat.Server.View.UsersServer;

import java.util.List;

public class PresenterServer implements IPresenterServer, IModelServer.OnFinishedListener {


    IViewServer iViewAllWords;
    IModelServer iModelAllWords;

    public PresenterServer(IViewServer iViewAllWords, IModelServer iModelAllWords) {
        this.iViewAllWords = iViewAllWords;
        this.iModelAllWords = iModelAllWords;
    }

    @Override
    public void requestDataFromServer() {
        iModelAllWords.getArrayList(this);
    }

    @Override
    public void onRefreshButtonClick() {
        if(iViewAllWords!=null){

        }
        iModelAllWords.getArrayList(this);


    }

    @Override
    public void onFinished(List<UsersServer> arrayList) {

        iViewAllWords.setDataToRecyclerView(arrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        iViewAllWords.onResponseFailure(t);
    }
}
