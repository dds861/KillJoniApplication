package com.chatserver.dd.chat.Players.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Players.Presenter.RepositoriesListPresenterPlayers;
import com.chatserver.dd.chat.R;

public class RecyclerAdapterPlayers extends RecyclerView.Adapter<ViewHolder> {

    private final RepositoriesListPresenterPlayers presenter;

    public RecyclerAdapterPlayers(RepositoriesListPresenterPlayers repositoriesPresenter) {
        this.presenter = repositoriesPresenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_players, null);
        return new ViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
