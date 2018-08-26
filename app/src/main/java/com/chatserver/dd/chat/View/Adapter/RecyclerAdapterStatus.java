package com.chatserver.dd.chat.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterStatus;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.ViewHolder.RepositoryViewHolderStatus;

public class RecyclerAdapterStatus extends RecyclerView.Adapter<RepositoryViewHolderStatus> {

    private final RepositoriesListPresenterStatus presenter;

    public RecyclerAdapterStatus(RepositoriesListPresenterStatus repositoriesPresenter) {
        this.presenter = repositoriesPresenter;
    }


    @NonNull
    @Override
    public RepositoryViewHolderStatus onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RepositoryViewHolderStatus(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_status, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolderStatus holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
