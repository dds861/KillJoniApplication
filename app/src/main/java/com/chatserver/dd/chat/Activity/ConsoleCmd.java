package com.chatserver.dd.chat.Activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chatserver.dd.chat.Model.ModelConsoleCmd;
import com.chatserver.dd.chat.Other.MyarenaToken;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Retrofit.APIService;
import com.chatserver.dd.chat.Retrofit.ConnectRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsoleCmd {

    private Context context;


    public ConsoleCmd(Context context) {
        this.context = context;
    }

    public void loadPlayersAction(View view, String playerName, RadioGroup radioGroup, EditText edMessage) {
        String cmdCommand;


        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbPlayersKick:
                cmdCommand = "amx_kick " + playerName;
                break;
            case R.id.rbPlayersSlap:
                cmdCommand = "amx_slap " + playerName;
                break;
            case R.id.rbPlayersSlay:
                cmdCommand = "amx_slay " + playerName;
                break;
            case R.id.rbPlayersBan:
                cmdCommand = "amx_ban 10 " + playerName + " banned";
                break;
            case R.id.rbPlayersGag:
                cmdCommand = "gag " + playerName;
                break;
            case R.id.rbMessageAllPlayers:
                cmdCommand = "amx_say " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllAdmins:
                cmdCommand = "amx_chat " + edMessage.getText().toString();
                break;
            case R.id.rbMessagePrivate:
                cmdCommand = "amx_psay " + playerName + " " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllHudLeft:
                cmdCommand = "amx_tsay green " + edMessage.getText().toString();
                break;
            case R.id.rbMessageAllHudCenter:
                cmdCommand = "amx_csay green " + edMessage.getText().toString();
                break;

            default:
                Toast.makeText(context, "Select action", Toast.LENGTH_SHORT).show();
                cmdCommand = "";
        }

        APIService apiService = new ConnectRetrofit(view).getApiServiceMyarena();

        Call<ModelConsoleCmd> call = apiService.getConsoleCmd("consolecmd", cmdCommand, new MyarenaToken(context).getToken());
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

    public void executeStatusCmdCommands(View view, int viewId) {
        switch (viewId) {

            case R.id.btnStart:
                executeCmdCommand(view, "start");
                break;
            case R.id.btnStop:
                executeCmdCommand(view, "stop");
                break;
            case R.id.btnRestart:
                executeCmdCommand(view, "restart");
                break;
            case R.id.btnChangeMap:
                executeCmdCommandMap(view, "changelevel", "cs_mansion");
                break;

            default:
                Toast.makeText(context, "Select action", Toast.LENGTH_SHORT).show();
        }


    }

    private void executeCmdCommand(View view, String query) {
        APIService apiService = new ConnectRetrofit(view).getApiServiceMyarena();

        Call<ModelConsoleCmd> call = apiService.getServerActions(query, new MyarenaToken(context).getToken());
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

    private void executeCmdCommandMap(View view, String query, String map) {
        APIService apiService = new ConnectRetrofit(view).getApiServiceMyarena();

        Call<ModelConsoleCmd> call = apiService.getServerActionsMap(query, map, new MyarenaToken(context).getToken());
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
