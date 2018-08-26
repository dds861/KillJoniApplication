package com.chatserver.dd.chat.Contract;

public interface MainContract {

    interface View {
    }

    interface Presenter {
    }

    interface Model {
        interface RepositoryRowViewAllWords {

            void setMessage(String message);

            void setEventTime(String eventTime);

            void setLastName(String lastName);
        }

        interface RepositoryRowViewAdmins {

            void setEventTime(String eventTime);

            void setIpAddress(String ipAddress);

            void setLastName(String lastName);
        }

        interface RepositoryRowViewPlayers {

            public void setTv_PlayerPid(int tv_PlayerPid);

            public void setTv_PlayerName(String tv_PlayerName);

            public void setTv_PlayerScore(int tv_PlayerScore);

            public void setTv_PlayerTime(String tv_PlayerTime);

            public void setCheckBox_player_select(String checkBox_player_select);
        }

        interface RepositoryRowViewStatus {


            void set_tv_status(String tv_status);

            void set_tv_online(String tv_online);

            void set_tv_serverId(String tv_serverId);

            void set_tv_serverName(String tv_serverName);

            void set_tv_serverAddress(String tv_serverAddress);

            void set_tv_serverMaxslots(String tv_serverMaxslots);

            void set_tv_serverLocation(String tv_serverLocation);

            void set_tv_serverType(String tv_serverType);

            void set_tv_serverDateblock(String tv_serverDateblock);

            void set_tv_serverDaystoblock(String tv_serverDaystoblock);

            void set_tv_tv_serverPlayersOnline(String tv_serverPlayersOnline);

            void set_tv_tv_serverMap(String tv_serverMap);
        }
    }


}
