package com.chatserver.dd.chat.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.chatserver.dd.chat.Contract.APIService;
import com.chatserver.dd.chat.Model.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.View.Model.ModelConsoleCmd;

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
        Call<ModelConsoleCmd> call = apiService.getConsoleCmd("consolecmd", cmdCommand, new MyarenaToken(context).getToken());
        executeCall(call);
    }


    public void cmdStartServer() {
        Call<ModelConsoleCmd> call = apiService.getServerActions("start", new MyarenaToken(context).getToken());
        executeCall(call);
    }

    public void cmdStopServer() {
        Call<ModelConsoleCmd> call = apiService.getServerActions("stop", new MyarenaToken(context).getToken());
        executeCall(call);
    }


    public void cmdRestartServer() {
        Call<ModelConsoleCmd> call = apiService.getServerActions("restart", new MyarenaToken(context).getToken());
        executeCall(call);
    }

    void executeCall(Call<ModelConsoleCmd> call) {
        call.enqueue(new Callback<ModelConsoleCmd>() {
            @Override
            public void onResponse(Call<ModelConsoleCmd> call, Response<ModelConsoleCmd> response) {
                ModelConsoleCmd modelConsoleCmd = response.body();

                Toast.makeText(context, modelConsoleCmd.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("autolog", "modelConsoleCmd.getMessage(): " + modelConsoleCmd.getMessage());
            }

            @Override
            public void onFailure(Call<ModelConsoleCmd> call, Throwable t) {

            }
        });
    }
}
