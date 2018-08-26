package com.chatserver.dd.chat.View.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.R;

public class RepositoryViewHolderAllWords extends RecyclerView.ViewHolder implements MainContract.Model.RepositoryRowViewAllWords {

    private TextView message, eventTime, lastName;

    public RepositoryViewHolderAllWords(View itemView) {
        super(itemView);
        message = (TextView) itemView.findViewById(R.id.message);
        eventTime = (TextView) itemView.findViewById(R.id.eventTimeChat);
        lastName = (TextView) itemView.findViewById(R.id.lastName);
    }


    @Override
    public void setMessage(String message) {
        this.message.setText(message);
    }

    @Override
    public void setEventTime(String eventTime) {
        this.eventTime.setText(eventTime);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }
}