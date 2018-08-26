package com.chatserver.dd.chat.Model.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chatserver.dd.chat.Model.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.Presenter.CmdMain;
import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterStatus;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.Adapter.RecyclerAdapterStatus;
import com.chatserver.dd.chat.View.Model.ModelStatusPlayers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityStatus extends AppCompatActivity implements View.OnClickListener {

    View view;

    public ActivityStatus(View view) {
        this.view = view;
    }

    public void getUserList() {
        Button btnStart = (Button) view.findViewById(R.id.btnStart);
        Button btnStop = (Button) view.findViewById(R.id.btnStop);
        Button btnRestart = (Button) view.findViewById(R.id.btnRestart);
        Button btnChangeMap = (Button) view.findViewById(R.id.btnChangeMap);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnRestart.setOnClickListener(this);
        btnChangeMap.setOnClickListener(this);


        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit();
        Call<ModelStatusPlayers> call = connectRetrofit.getApiServiceMyarena().getUserData("status", getToken(view.getContext()));

        call.enqueue(new Callback<ModelStatusPlayers>() {
            @Override
            public void onResponse(Call<ModelStatusPlayers> call, Response<ModelStatusPlayers> response) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewStatus);
                ModelStatusPlayers model_status = response.body();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                RepositoriesListPresenterStatus repositoriesListPresenter = new RepositoriesListPresenterStatus(model_status);

                RecyclerAdapterStatus adapterMenu1 = new RecyclerAdapterStatus(repositoriesListPresenter);

                recyclerView.setAdapter(adapterMenu1);


            }

            @Override
            public void onFailure(Call<ModelStatusPlayers> call, Throwable t) {
            }
        });


    }

    private String getToken(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }

    @Override
    public void onClick(View view) {
        CmdMain consoleCmd = new CmdMain(view.getContext());
        switch (view.getId()) {
            case R.id.btnStart:
                consoleCmd.executeStatusCmdCommands(view, R.id.btnStart);
                break;
            case R.id.btnStop:
                consoleCmd.executeStatusCmdCommands(view, R.id.btnStop);
                break;
            case R.id.btnRestart:
                consoleCmd.executeStatusCmdCommands(view, R.id.btnRestart);
                break;
            case R.id.btnChangeMap:
                consoleCmd.executeStatusCmdCommands(view, R.id.btnChangeMap);
                break;
        }
    }
}
