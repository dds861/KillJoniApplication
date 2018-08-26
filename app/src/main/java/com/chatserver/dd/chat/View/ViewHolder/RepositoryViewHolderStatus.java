package com.chatserver.dd.chat.View.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.R;

public class RepositoryViewHolderStatus extends RecyclerView.ViewHolder implements MainContract.Model.RepositoryRowViewStatus {

    private TextView tv_status;
    private TextView tv_online;
    private TextView tv_serverId;
    private TextView tv_serverName;
    private TextView tv_serverAddress;
    private TextView tv_serverMaxslots;
    private TextView tv_serverLocation;
    private TextView tv_serverType;
    private TextView tv_serverDateblock;
    private TextView tv_serverDaystoblock;
    private TextView tv_serverPlayersOnline;
    private TextView tv_serverMap;

    public RepositoryViewHolderStatus(View itemView) {
        super(itemView);
        this.tv_status = (TextView) itemView.findViewById(R.id.tv_status);
        this.tv_online = (TextView) itemView.findViewById(R.id.tv_online);
        this.tv_serverId = (TextView) itemView.findViewById(R.id.tv_serverId);
        this.tv_serverName = (TextView) itemView.findViewById(R.id.tv_serverName);
        this.tv_serverAddress = (TextView) itemView.findViewById(R.id.tv_serverAddress);
        this.tv_serverMaxslots = (TextView) itemView.findViewById(R.id.tv_serverMaxslots);
        this.tv_serverLocation = (TextView) itemView.findViewById(R.id.tv_serverLocation);
        this.tv_serverType = (TextView) itemView.findViewById(R.id.tv_serverType);
        this.tv_serverDateblock = (TextView) itemView.findViewById(R.id.tv_serverDateblock);
        this.tv_serverDaystoblock = (TextView) itemView.findViewById(R.id.tv_serverDaystoblock);
        this.tv_serverPlayersOnline = (TextView) itemView.findViewById(R.id.tv_serverPlayersOnline);
        this.tv_serverMap = (TextView) itemView.findViewById(R.id.tv_serverMap);
    }


    @Override
    public void set_tv_status(String tv_status) {
        this.tv_status.setText(tv_status);
    }

    @Override
    public void set_tv_online(String tv_online) {
        this.tv_online.setText(tv_online);
    }

    @Override
    public void set_tv_serverId(String tv_serverId) {
        this.tv_serverId.setText(tv_serverId);
    }

    @Override
    public void set_tv_serverName(String tv_serverName) {
        this.tv_serverName.setText(tv_serverName);
    }

    @Override
    public void set_tv_serverAddress(String tv_serverAddress) {
        this.tv_serverAddress.setText(tv_serverAddress);
    }

    @Override
    public void set_tv_serverMaxslots(String tv_serverMaxslots) {
        this.tv_serverMaxslots.setText(tv_serverMaxslots);
    }

    @Override
    public void set_tv_serverLocation(String tv_serverLocation) {
        this.tv_serverLocation.setText(tv_serverLocation);
    }

    @Override
    public void set_tv_serverType(String tv_serverType) {
        this.tv_serverType.setText(tv_serverType);
    }

    @Override
    public void set_tv_serverDateblock(String tv_serverDateblock) {
        this.tv_serverDateblock.setText(tv_serverDateblock);
    }

    @Override
    public void set_tv_serverDaystoblock(String tv_serverDaystoblock) {
        this.tv_serverDaystoblock.setText(tv_serverDaystoblock);
    }

    @Override
    public void set_tv_tv_serverPlayersOnline(String tv_serverPlayersOnline) {
        this.tv_serverPlayersOnline.setText(tv_serverPlayersOnline);
    }

    @Override
    public void set_tv_tv_serverMap(String tv_serverMap) {
        this.tv_serverMap.setText(tv_serverMap);
    }
}