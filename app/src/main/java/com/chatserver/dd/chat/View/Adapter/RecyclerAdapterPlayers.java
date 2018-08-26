package com.chatserver.dd.chat.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterPlayers;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.ViewHolder.RepositoryViewHolderPlayers;

public class RecyclerAdapterPlayers extends RecyclerView.Adapter<RepositoryViewHolderPlayers> {

    private final RepositoriesListPresenterPlayers presenter;

    public RecyclerAdapterPlayers(RepositoriesListPresenterPlayers repositoriesPresenter) {
        this.presenter = repositoriesPresenter;
    }

    @Override
    public RepositoryViewHolderPlayers onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryViewHolderPlayers(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_players, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolderPlayers holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
