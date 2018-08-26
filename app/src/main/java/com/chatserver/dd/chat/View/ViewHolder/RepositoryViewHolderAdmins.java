package com.chatserver.dd.chat.View.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.R;

public class RepositoryViewHolderAdmins extends RecyclerView.ViewHolder implements MainContract.Model.RepositoryRowViewAdmins {

    private TextView ipAddress, eventTime, lastName;

    public RepositoryViewHolderAdmins(View itemView) {
        super(itemView);
        ipAddress = (TextView) itemView.findViewById(R.id.message);
        eventTime = (TextView) itemView.findViewById(R.id.eventTimeChat);
        lastName = (TextView) itemView.findViewById(R.id.lastName);
    }


    @Override
    public void setEventTime(String eventTime) {
        this.eventTime.setText(eventTime);
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress.setText(ipAddress);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }
}