package com.chatserver.dd.chat.Presenter;

import com.chatserver.dd.chat.Contract.MainContract;
import com.chatserver.dd.chat.View.Model.ModelStatusPlayers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RepositoriesListPresenterStatus {
    private final ModelStatusPlayers repositories;

    public RepositoriesListPresenterStatus(ModelStatusPlayers repositories) {
        this.repositories = repositories;
    }


    public void onBindRepositoryRowViewAtPosition(int position, MainContract.Model.RepositoryRowViewStatus rowView) {
//        Model repo = repositories.get(position);
//        rowView.setEventTime(repo.getEventTime());
//        rowView.setLastName(repo.getLastName());
//        rowView.setMessage(repo.getMessage());



        if (!repositories.getStatus().equals("NO")) {
            String tv_status = repositories.getStatus();
            String tv_online = String.valueOf(repositories.getOnline());
            String tv_serverId = repositories.getServer_id();
            String tv_serverName = repositories.getServer_name();
            String tv_serverAddress = repositories.getServer_address();
            String tv_serverMaxslots = repositories.getServer_maxslots();
            String tv_serverLocation = repositories.getServer_location();
            String tv_serverType = repositories.getServer_type();
            String tv_serverDaystoblock = String.valueOf(repositories.getServer_daystoblock());
            String tv_serverPlayersOnline = String.valueOf(repositories.getData().getS().getPlayers());
            String tv_serverMap = repositories.getData().getS().getMap();

            rowView.set_tv_status(tv_status);
            rowView.set_tv_online(tv_online);
            rowView.set_tv_serverId(tv_serverId);
            rowView.set_tv_serverName(tv_serverName);
            rowView.set_tv_serverAddress(tv_serverAddress);
            rowView.set_tv_serverMaxslots(tv_serverMaxslots);
            rowView.set_tv_serverLocation(tv_serverLocation);
            rowView.set_tv_serverType(tv_serverType);
            rowView.set_tv_serverDaystoblock(tv_serverDaystoblock);
            rowView.set_tv_tv_serverPlayersOnline(tv_serverPlayersOnline);
            rowView.set_tv_tv_serverMap(tv_serverMap);



            long seconds = Long.valueOf(repositories.getServer_dateblock());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String dateString = formatter.format(new Date(seconds * 1000L));
            rowView.set_tv_serverDateblock(dateString);

        }
    }

    public int getRepositoriesRowsCount() {
        return 1;
    }

}
