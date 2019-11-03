package com.chatserver.dd.chat.Admins.Presenter;


import com.chatserver.dd.chat.Admins.Model.IModelAdmins;
import com.chatserver.dd.chat.Admins.View.IViewAdmins;
import com.chatserver.dd.chat.Admins.View.UsersAdmins;

import java.util.List;

public class PresenterAdmins implements IPresenterAdmins {


    IViewAdmins view;
    IModelAdmins model;

    public PresenterAdmins(IViewAdmins iViewAllWords, IModelAdmins iModelAllWords) {
        this.view = iViewAllWords;
        this.model = iModelAllWords;
    }

    @Override
    public void requestDataFromServer() {
        view.showProgressBar();
        model.getArrayList(new IModelAdmins.OnFinishedListener() {
            @Override
            public void resultsOnRequest(List<UsersAdmins> arrayList) {
                view.setDataToRecyclerView(arrayList);
                view.hideProgressBar();
            }

            @Override
            public void onFailure(Throwable t) {
                view.onResponseFailure(t);
            }
        });
    }

    @Override
    public void onRefreshButtonClick() {
        model.getArrayList(new IModelAdmins.OnFinishedListener() {
            @Override
            public void resultsOnRequest(List<UsersAdmins> arrayList) {
                view.setDataToRecyclerView(arrayList);
                view.hideProgressBar();
            }

            @Override
            public void onFailure(Throwable t) {
                view.onResponseFailure(t);
            }
        });
    }
}
