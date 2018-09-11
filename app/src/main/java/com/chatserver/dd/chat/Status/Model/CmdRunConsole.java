package com.chatserver.dd.chat.Status.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.chatserver.dd.chat.Contract.APIService;
import com.chatserver.dd.chat.Mvp.Model.ConnectRetrofit;
import com.chatserver.dd.chat.Mvp.Model.MyarenaToken;
import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CmdRunConsole {

    private Context context;
    private APIService apiService;


    public CmdRunConsole(Context context) {
        this.context = context;
        apiService = new ConnectRetrofit().getApiServiceMyarena();
    }

    public void executeCmdConsole(String cmdCommand) {
        Call<ViewConsoleCmd> call = apiService.getConsoleCmd("consolecmd", cmdCommand, new MyarenaToken(context).getToken());
        executeCall(call);
    }


    public void cmdStartServer() {
        Call<ViewConsoleCmd> call = apiService.getServerActions("start", new MyarenaToken(context).getToken());
        executeCall(call);
    }

    public void cmdStopServer() {
        Call<ViewConsoleCmd> call = apiService.getServerActions("stop", new MyarenaToken(context).getToken());
        executeCall(call);
    }


    public void cmdRestartServer() {
        Call<ViewConsoleCmd> call = apiService.getServerActions("restart", new MyarenaToken(context).getToken());
        executeCall(call);
    }

    void executeCall(Call<ViewConsoleCmd> call) {
        call.enqueue(new Callback<ViewConsoleCmd>() {
            @Override
            public void onResponse(Call<ViewConsoleCmd> call, Response<ViewConsoleCmd> response) {
                ViewConsoleCmd modelConsoleCmd = response.body();

                Toast.makeText(context, modelConsoleCmd.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("autolog", "modelConsoleCmd.getPlayers2(): " + modelConsoleCmd.getMessage());
            }

            @Override
            public void onFailure(Call<ViewConsoleCmd> call, Throwable t) {

            }
        });
    }
}
