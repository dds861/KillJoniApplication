package com.chatserver.dd.chat.Cmd.Model;


import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd;
import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers;
import com.chatserver.dd.chat.Contract.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelCmd implements IModelCmd {
    ;

    @Override
    public void getPlayersList(final OnFinishedListener onFinishedListener) {

        try {
            String url = "https://www.myarena.ru";
            Retrofit retrofit = null;
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            APIService service = retrofit.create(APIService.class);
            Call<ViewStatusPlayers> call = service.getPlayers2("status", "2e5dcefb0c72d69ead8c2c1d0a2ba358");
            call.enqueue(new Callback<ViewStatusPlayers>() {
                @Override
                public void onResponse(Call<ViewStatusPlayers> call, Response<ViewStatusPlayers> response) {
                    onFinishedListener.onFinishedPlayers(response.body());
                }

                @Override
                public void onFailure(Call<ViewStatusPlayers> call, Throwable t) {
                }
            });
        } catch (Exception e) {
        }
    }

    @Override
    public void onExecuteCmd(final OnFinishedListenerCmd onFinishedListenerCmd, String cmdCommand) {
        try {
            String url = "https://www.myarena.ru";
            Retrofit retrofit = null;
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            APIService service = retrofit.create(APIService.class);
            Call<ViewConsoleCmd> call = service.getConsoleCmd("consolecmd", cmdCommand, "2e5dcefb0c72d69ead8c2c1d0a2ba358");
            call.enqueue(new Callback<ViewConsoleCmd>() {
                @Override
                public void onResponse(Call<ViewConsoleCmd> call, Response<ViewConsoleCmd> response) {
                    onFinishedListenerCmd.onFinishedCmd(response.body());
                }

                @Override
                public void onFailure(Call<ViewConsoleCmd> call, Throwable t) {
                    onFinishedListenerCmd.onFailureCmd(t);
                }
            });
        } catch (Exception e) {
        }
    }


}
