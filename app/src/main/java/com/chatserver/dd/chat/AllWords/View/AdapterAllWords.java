package com.chatserver.dd.chat.allwords.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.databinding.ContentAllWordsBinding;

import java.util.List;

public class AdapterAllWords extends RecyclerView.Adapter<AdapterAllWords.ViewHolder> {

    private List<UsersAllWords> usersAllWords;

    public AdapterAllWords(List<UsersAllWords> usersAllWords) {
        this.usersAllWords = usersAllWords;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ContentAllWordsBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.content_all_words, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.bind(usersAllWords.get(position));
    }

    @Override
    public int getItemCount() {
        return usersAllWords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventTime, message, lastName;

        ContentAllWordsBinding binding;

        public ViewHolder(ContentAllWordsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UsersAllWords usersAllWords) {
            binding.setChats(usersAllWords);
            binding.executePendingBindings();
        }
    }
}