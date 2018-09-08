package com.chatserver.dd.chat.Players.Presenter;

import android.util.Log;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.Players.View.ViewStatusPlayers;

import java.util.List;

public class RepositoriesListPresenterPlayers implements MainContract.Presenter.RepositoriesListPresenterPlayers {
    private final List<ViewStatusPlayers.P> repositories;

    public RepositoriesListPresenterPlayers(ViewStatusPlayers repositories) {
        this.repositories = repositories.getData().getP();
    }


    public void onBindRepositoryRowViewAtPosition(int position, MainContract.Model.RepositoryRowViewPlayers rowView) {
        ViewStatusPlayers.P repo = repositories.get(position);
        rowView.setTv_PlayerPid(repo.getPid());
        rowView.setTv_PlayerName(repo.getName());
        rowView.setTv_PlayerScore(repo.getScore());
        rowView.setTv_PlayerTime(repo.getTime());
    }

    public int getRepositoriesRowsCount() {
        return repositories.size();
    }



    @Override
    public void onItemInteraction(int adapterPosition, String namePlayer) {
        Log.i("autolog", "adapterPosition: " + adapterPosition);
        Log.i("autolog", "namePlayer: " + namePlayer);
    }
}
