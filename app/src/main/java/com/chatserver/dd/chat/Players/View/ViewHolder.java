package com.chatserver.dd.chat.Players.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.Players.Presenter.RepositoriesListPresenterPlayers;
import com.chatserver.dd.chat.R;

public class ViewHolder extends RecyclerView.ViewHolder implements MainContract.Model.RepositoryRowViewPlayers, View.OnClickListener {

    private TextView tv_PlayerPid;
    private TextView tv_PlayerName;
    private TextView tv_PlayerScore;
    private TextView tv_PlayerTime;
    private CheckBox checkBox_player_select;

    RepositoriesListPresenterPlayers presenter;

    public ViewHolder(View itemView, RepositoriesListPresenterPlayers presenter) {
        super(itemView);
        this.tv_PlayerPid = (TextView) itemView.findViewById(R.id.tv_PlayerPid);
        this.tv_PlayerName = (TextView) itemView.findViewById(R.id.tv_Name);
        this.tv_PlayerScore = (TextView) itemView.findViewById(R.id.tv_Score);
        this.tv_PlayerTime = (TextView) itemView.findViewById(R.id.tv_Time);
        this.checkBox_player_select = itemView.findViewById(R.id.checkBox_player_select);
        this.presenter = presenter;
        itemView.setOnClickListener(this);
    }


    @Override
    public void setTv_PlayerPid(int tv_PlayerPid) {
        this.tv_PlayerPid.setText(String.valueOf(tv_PlayerPid));
    }

    @Override
    public void setTv_PlayerName(String tv_PlayerName) {
        this.tv_PlayerName.setText(tv_PlayerName);
    }

    @Override
    public void setTv_PlayerScore(int tv_PlayerScore) {
        this.tv_PlayerScore.setText(String.valueOf(tv_PlayerScore));
    }

    @Override
    public void setTv_PlayerTime(String tv_PlayerTime) {
        this.tv_PlayerTime.setText(tv_PlayerTime);
    }

    @Override
    public void setCheckBox_player_select(String checkBox_player_select) {
        this.checkBox_player_select.setText(checkBox_player_select);
    }

    @Override
    public void onClick(View view) {
        if (presenter != null) {
            presenter.onItemInteraction(getAdapterPosition(), String.valueOf(tv_PlayerName.getText()));



        }
    }
}