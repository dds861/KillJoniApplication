package com.chatserver.dd.chat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chatserver.dd.chat.Model.Model_Status_Players;
import com.chatserver.dd.chat.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dd on 03.05.2017.
 */

public class AdapterStatus2 extends RecyclerView.Adapter<AdapterStatus2.ViewHolder> {

    private Context context;
    private Model_Status_Players modelStatus;

    public AdapterStatus2(Context context, Model_Status_Players modelStatus) {
        this.context = context;
        this.modelStatus = modelStatus;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_status, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (!modelStatus.getStatus().equals("NO")) {
            String tv_status = modelStatus.getStatus();
            String tv_online = String.valueOf(modelStatus.getOnline());
            String tv_serverId = modelStatus.getServer_id();
            String tv_serverName = modelStatus.getServer_name();
            String tv_serverAddress = modelStatus.getServer_address();
            String tv_serverMaxslots = modelStatus.getServer_maxslots();
            String tv_serverLocation = modelStatus.getServer_location();
            String tv_serverType = modelStatus.getServer_type();
            String tv_serverDaystoblock = String.valueOf(modelStatus.getServer_daystoblock());
            String tv_serverPlayersOnline = String.valueOf(modelStatus.getData().getS().getPlayers());
            String tv_serverMap = modelStatus.getData().getS().getMap();


            holder.tv_status.setText(tv_status);
            holder.tv_online.setText(tv_online);
            holder.tv_serverId.setText(tv_serverId);
            holder.tv_serverName.setText(tv_serverName);
            holder.tv_serverAddress.setText(tv_serverAddress);
            holder.tv_serverMaxslots.setText(tv_serverMaxslots);
            holder.tv_serverLocation.setText(tv_serverLocation);
            holder.tv_serverType.setText(tv_serverType);
            holder.tv_serverDaystoblock.setText(tv_serverDaystoblock);

            holder.tv_serverPlayersOnline.setText(tv_serverPlayersOnline);
            holder.tv_serverMap.setText(tv_serverMap);


            long seconds = Long.valueOf(modelStatus.getServer_dateblock());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String dateString = formatter.format(new Date(seconds * 1000L));
            holder.tv_serverDateblock.setText(dateString);

        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_status;
        TextView tv_online;
        TextView tv_serverId;
        TextView tv_serverName;
        TextView tv_serverAddress;
        TextView tv_serverMaxslots;
        TextView tv_serverLocation;
        TextView tv_serverType;
        TextView tv_serverDateblock;
        TextView tv_serverDaystoblock;
        TextView tv_serverPlayersOnline;
        TextView tv_serverMap;

        public ViewHolder(View itemView) {

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
    }
}
