package com.chatserver.dd.chat.Presenter;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.View.Model.ModelAdminConnect;

import java.util.List;

public class RepositoriesListPresenterAdmins {
    private final List<ModelAdminConnect> repositories;

    public RepositoriesListPresenterAdmins(List<ModelAdminConnect> repositories) {
        this.repositories = repositories;
    }


    public void onBindRepositoryRowViewAtPosition(int position, MainContract.Model.RepositoryRowViewAdmins rowView) {
        ModelAdminConnect repo = repositories.get(position);
        rowView.setEventTime(repo.getEventTime());
        rowView.setLastName(repo.getLastName());
        rowView.setIpAddress(repo.getIpAddress());
    }

    public int getRepositoriesRowsCount() {
        return repositories.size();
    }

}
