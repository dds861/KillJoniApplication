package com.chatserver.dd.chat.Presenter;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.View.Model.ModelChat;

import java.util.List;

public class RepositoriesListPresenterAllWords {
    private final List<ModelChat> repositories;

    public RepositoriesListPresenterAllWords(List<ModelChat> repositories) {
        this.repositories = repositories;
    }


    public void onBindRepositoryRowViewAtPosition(int position, MainContract.Model.RepositoryRowViewAllWords rowView) {
        ModelChat repo = repositories.get(position);
        rowView.setEventTime(repo.getEventTime());
        rowView.setLastName(repo.getLastName());
        rowView.setMessage(repo.getMessage());
    }

    public int getRepositoriesRowsCount() {
        return repositories.size();
    }

}
