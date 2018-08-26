package com.chatserver.dd.chat.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterAllWords;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.ViewHolder.RepositoryViewHolderAllWords;

public class RecyclerAdapterAllWords extends RecyclerView.Adapter<RepositoryViewHolderAllWords> {

    private final RepositoriesListPresenterAllWords presenter;

    public RecyclerAdapterAllWords(RepositoriesListPresenterAllWords repositoriesPresenter) {
        this.presenter = repositoriesPresenter;
    }

    @Override
    public RepositoryViewHolderAllWords onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryViewHolderAllWords(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_all_words, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolderAllWords holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
