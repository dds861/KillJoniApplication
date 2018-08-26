package com.chatserver.dd.chat.Presenter;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.View.Model.ModelStatusPlayers;

import java.util.List;

public class RepositoriesListPresenterPlayers {
    private final List<ModelStatusPlayers.P> repositories;

    public RepositoriesListPresenterPlayers(ModelStatusPlayers repositories) {
        this.repositories = repositories.getData().getP();
    }


    public void onBindRepositoryRowViewAtPosition(int position, MainContract.Model.RepositoryRowViewPlayers rowView) {
        ModelStatusPlayers.P repo = repositories.get(position);
        rowView.setTv_PlayerPid(repo.getPid());
        rowView.setTv_PlayerName(repo.getName());
        rowView.setTv_PlayerScore(repo.getScore());
        rowView.setTv_PlayerTime(repo.getTime());
    }

    public int getRepositoriesRowsCount() {
        return repositories.size();
    }

}
