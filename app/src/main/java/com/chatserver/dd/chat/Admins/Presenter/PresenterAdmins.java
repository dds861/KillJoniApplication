package com.chatserver.dd.chat.Admins.Presenter;


import com.chatserver.dd.chat.Admins.Model.IModelAdmins;
import com.chatserver.dd.chat.Admins.View.IViewAdmins;
import com.chatserver.dd.chat.Admins.View.UsersAdmins;

import java.util.List;

public class PresenterAdmins implements IPresenterAdmins, IModelAdmins.OnFinishedListener {


    IViewAdmins view;
    IModelAdmins iModelAdmins;

    public PresenterAdmins(IViewAdmins iViewAllWords, IModelAdmins iModelAllWords) {
        this.view = iViewAllWords;
        this.iModelAdmins = iModelAllWords;
    }

    @Override
    public void requestDataFromServer() {
        view.showProgressBar();
        iModelAdmins.getArrayList(this);
    }

    @Override
    public void onRefreshButtonClick() {
        if(view !=null){

        }
        iModelAdmins.getArrayList(this);


    }

    @Override
    public void onFinished(List<UsersAdmins> arrayList) {

        view.setDataToRecyclerView(arrayList);
        view.hideProgressBar();
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
