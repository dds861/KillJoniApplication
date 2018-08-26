package com.chatserver.dd.chat.Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatserver.dd.chat.Model.Activity.ActivityAdminConnect;
import com.chatserver.dd.chat.Model.Activity.ActivityAllWords;
import com.chatserver.dd.chat.Model.Activity.ActivityMessage;
import com.chatserver.dd.chat.Model.Activity.ActivityPlayers;
import com.chatserver.dd.chat.Model.Activity.ActivityServerWords;
import com.chatserver.dd.chat.Model.Activity.ActivityStatus;
import com.chatserver.dd.chat.Model.Activity.ActivityVipWords;
import com.chatserver.dd.chat.R;

public class MainView {


    public View getMainView(LayoutInflater inflater, ViewGroup container, int sectionNumber) {
        View rootView = null;

        switch (sectionNumber) {
            case 1:
                rootView = inflater.inflate(R.layout.fragment_all_words, container, false);
                ActivityAllWords activityAllWords = new ActivityAllWords(rootView);
                activityAllWords.getUserList();
                break;
            case 2:
                rootView = inflater.inflate(R.layout.fragment_all_words, container, false);
                ActivityServerWords serverWords = new ActivityServerWords(rootView);
                serverWords.getUserList();
                break;
            case 3:
                rootView = inflater.inflate(R.layout.fragment_all_words, container, false);
                ActivityVipWords vipWords2 = new ActivityVipWords(rootView);
                vipWords2.getUserList();
                break;
            case 4:
                rootView = inflater.inflate(R.layout.fragment_all_words, container, false);
                ActivityAdminConnect adminConnect2 = new ActivityAdminConnect(rootView);
                adminConnect2.getUserList();
                break;
            case 5:
                rootView = inflater.inflate(R.layout.fragment_status, container, false);
                ActivityStatus activityStatus2 = new ActivityStatus(rootView);
                activityStatus2.getUserList();
                break;
            case 6:
                rootView = inflater.inflate(R.layout.fragment_players, container, false);
                ActivityPlayers activityStatus3 = new ActivityPlayers(rootView);
                activityStatus3.getPlayersList();
                break;
            case 7:
                rootView = inflater.inflate(R.layout.fragment_message, container, false);
                ActivityMessage activityMessage = new ActivityMessage(rootView);
                activityMessage.setPlayersList();
                break;
        }
        return rootView;
    }
}
