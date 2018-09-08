package com.chatserver.dd.chat.Message.Model;

import com.chatserver.dd.chat.Message.IMessage;
import com.chatserver.dd.chat.Mvp.Model.ConnectRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MessageModel implements IMessage.IMessageModel {


    @Override
    public List<String> getPlayersList() {

        final List<String> playersList = new ArrayList<>();

        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit();
        Call<List<ViewMessageNetwork.P>> call = connectRetrofit.getApiServiceMyarena().getPlayers2("status", "2e5dcefb0c72d69ead8c2c1d0a2ba358");

        call.enqueue(new Callback<List<ViewMessageNetwork.P>>() {
            @Override
            public void onResponse(Call<List<ViewMessageNetwork.P>> call, Response<List<ViewMessageNetwork.P>> response) {
                List<ViewMessageNetwork.P> model_status = response.body();
                for (int i = 0; i < model_status.size(); i++) {
                    playersList.add(model_status.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<List<ViewMessageNetwork.P>> call, Throwable t) {
            }
        });
        return playersList;
    }
}
