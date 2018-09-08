package com.chatserver.dd.chat.Vip.Presenter;


import com.chatserver.dd.chat.Vip.Model.IModel;
import com.chatserver.dd.chat.Vip.View.IView;
import com.chatserver.dd.chat.Vip.View.UsersVip;

import java.util.List;

public class Presenter implements IPresenter, IModel.OnFinishedListener {


    IView iViewAllWords;
    IModel iModelAllWords;

    public Presenter(IView iViewAllWords, IModel iModelAllWords) {
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
    public void onFinished(List<UsersVip> arrayList) {

        iViewAllWords.setDataToRecyclerView(arrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        iViewAllWords.onResponseFailure(t);
    }
}
