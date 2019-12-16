package com.chatserver.dd.chat.allwords.presenter;

import com.chatserver.dd.chat.allwords.model.IModelAllWords;
import com.chatserver.dd.chat.allwords.view.IViewAllWords;
import com.chatserver.dd.chat.allwords.view.UsersAllWords;

import java.util.List;

public class PresenterAllWords implements IPresenterAllWords, IModelAllWords.OnFinishedListener {


    IViewAllWords iViewAllWords;
    IModelAllWords iModelAllWords;

    public PresenterAllWords(IViewAllWords iViewAllWords, IModelAllWords iModelAllWords) {
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
    public void onFinished(List<UsersAllWords> arrayList) {

        iViewAllWords.setDataToRecyclerView(arrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        iViewAllWords.onResponseFailure(t);
    }


}
