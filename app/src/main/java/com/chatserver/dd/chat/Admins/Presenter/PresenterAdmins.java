package com.chatserver.dd.chat.Admins.Presenter;


import com.chatserver.dd.chat.Admins.Model.IModelAdmins;
import com.chatserver.dd.chat.Admins.View.IViewAdmins;
import com.chatserver.dd.chat.Admins.View.UsersAdmins;

import java.util.List;

public class PresenterAdmins implements IPresenterAdmins, IModelAdmins.OnFinishedListener {


    IViewAdmins iViewAllWords;
    IModelAdmins iModelAllWords;

    public PresenterAdmins(IViewAdmins iViewAllWords, IModelAdmins iModelAllWords) {
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
    public void onFinished(List<UsersAdmins> arrayList) {

        iViewAllWords.setDataToRecyclerView(arrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        iViewAllWords.onResponseFailure(t);
    }
}
