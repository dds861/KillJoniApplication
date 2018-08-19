package com.chatserver.dd.chat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chatserver.dd.chat.Activity.ConsoleCmd;
import com.chatserver.dd.chat.Model.ModelStatusPlayers;
import com.chatserver.dd.chat.R;

import java.util.List;

/**
 * Created by dd on 03.05.2017.
 */

public class AdapterPlayers extends RecyclerView.Adapter<AdapterPlayers.ViewHolder> {

    private Context context;
    private List<ModelStatusPlayers.P> statusPlayersList;
    private RadioGroup radioGroup;
    private EditText edMessage;

    public AdapterPlayers(Context context, ModelStatusPlayers statusPlayersList, RadioGroup radioGroup, EditText edMessage) {
        this.context = context;
        this.statusPlayersList = statusPlayersList.getData().getP();
        this.radioGroup = radioGroup;
        this.edMessage = edMessage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_players, null);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        String tv_PlayerPid = String.valueOf(statusPlayersList.get(position).getPid());
        String tv_PlayerName = statusPlayersList.get(position).getName();
        String tv_PlayerScore = String.valueOf(statusPlayersList.get(position).getScore());
        String tv_PlayerTime = statusPlayersList.get(position).getTime();

        holder.tv_PlayerPid.setText(tv_PlayerPid);
        holder.tv_PlayerName.setText(tv_PlayerName);
        holder.tv_PlayerScore.setText(tv_PlayerScore);
        holder.tv_PlayerTime.setText(tv_PlayerTime);


        final String PlayerName = String.valueOf(holder.tv_PlayerName.getText());

        //При нажатии на список игроков, отправится запрос, запрос будет содержать какая radio точка выбрана
        holder.tv_PlayerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsoleCmd consoleCmd = new ConsoleCmd(context);
                consoleCmd.loadPlayersAction(holder.itemView, PlayerName, radioGroup, edMessage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusPlayersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_PlayerPid;
        TextView tv_PlayerName;
        TextView tv_PlayerScore;
        TextView tv_PlayerTime;

        public ViewHolder(View itemView) {

            super(itemView);

            this.tv_PlayerPid = (TextView) itemView.findViewById(R.id.tv_PlayerPid);
            this.tv_PlayerName = (TextView) itemView.findViewById(R.id.tv_PlayerName);
            this.tv_PlayerScore = (TextView) itemView.findViewById(R.id.tv_PlayerScore);
            this.tv_PlayerTime = (TextView) itemView.findViewById(R.id.tv_PlayerTime);

        }
    }
}
