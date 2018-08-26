package com.chatserver.dd.chat.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterAdmins;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.ViewHolder.RepositoryViewHolderAdmins;

public class RecyclerAdapterAdmins extends RecyclerView.Adapter<RepositoryViewHolderAdmins> {

    private final RepositoriesListPresenterAdmins presenter;

    public RecyclerAdapterAdmins(RepositoriesListPresenterAdmins repositoriesPresenter) {
        this.presenter = repositoriesPresenter;
    }

    @Override
    public RepositoryViewHolderAdmins onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryViewHolderAdmins(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_all_words, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolderAdmins holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
