package com.chatserver.dd.chat.Cmd.View;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.chatserver.dd.chat.Cmd.Presenter.IPresenterCmd;
import com.chatserver.dd.chat.R;

public class AdapterCmd extends RecyclerView.Adapter<AdapterCmd.ViewHolder> {

    private ViewStatusPlayers viewStatusPlayers;

    private IPresenterCmd iPresenterCmd = null;
    private int lastSelectedPosition = -1;

    public AdapterCmd(ViewStatusPlayers viewStatusPlayers, IPresenterCmd iPresenterCmd) {
        this.viewStatusPlayers = viewStatusPlayers;
        this.iPresenterCmd = iPresenterCmd;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_cmd, null);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final ViewStatusPlayers.P viewStatusPlayers2 = viewStatusPlayers.getData().getP().get(position);

        holder.tv_PlayerPid.setText(String.valueOf(viewStatusPlayers2.getPid()));
        holder.tv_Name.setText(viewStatusPlayers2.getName());
        holder.tv_Score.setText(String.valueOf(viewStatusPlayers2.getScore()));
        holder.tv_Time.setText(viewStatusPlayers2.getTime());

        holder.radioButton.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        if (viewStatusPlayers != null) {
            return viewStatusPlayers.getData().getP().size();

        } else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_PlayerPid, tv_Name, tv_Score, tv_Time;
        private RadioButton radioButton;
        private LinearLayout linearLayout;


        public ViewHolder(final View itemView) {
            super(itemView);
            tv_PlayerPid = (TextView) itemView.findViewById(R.id.tv_PlayerPid);
            tv_Name = (TextView) itemView.findViewById(R.id.tv_Name);
            tv_Score = (TextView) itemView.findViewById(R.id.tv_Score);
            tv_Time = (TextView) itemView.findViewById(R.id.tv_Time);
            radioButton = itemView.findViewById(R.id.radiobtn_player_select);
            linearLayout = itemView.findViewById(R.id.linearLayout);

            linearLayout.setOnClickListener(this);
            tv_PlayerPid.setOnClickListener(this);
            tv_Name.setOnClickListener(this);
            tv_Score.setOnClickListener(this);
            tv_Time.setOnClickListener(this);
            radioButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            lastSelectedPosition = getAdapterPosition();
            notifyDataSetChanged();
            Log.i("autolog", "tv_Name.getText(): " + tv_Name.getText());
            iPresenterCmd.onSetNameToEditText(String.valueOf(tv_Name.getText()));

        }
    }
}