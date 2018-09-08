package com.chatserver.dd.chat.Players.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatserver.dd.chat.Mvp.Model.ConnectRetrofit;
import com.chatserver.dd.chat.Players.Presenter.RepositoriesListPresenterPlayers;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Players.View.RecyclerAdapterPlayers;
import com.chatserver.dd.chat.Players.View.ViewStatusPlayers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityPlayers extends AppCompatActivity {

    View view;

    public ActivityPlayers(View view) {
        this.view = view;
    }

    public void getPlayersList() {

        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit();
        Call<ViewStatusPlayers> call = connectRetrofit.getApiServiceMyarena().getPlayers("status", getToken(view.getContext()));

        call.enqueue(new Callback<ViewStatusPlayers>() {
            @Override
            public void onResponse(Call<ViewStatusPlayers> call, Response<ViewStatusPlayers> response) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPlayers);
                ViewStatusPlayers model_status = response.body();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                RepositoriesListPresenterPlayers repositoriesListPresenter = new RepositoriesListPresenterPlayers(model_status);

                RecyclerAdapterPlayers adapterMenu1 = new RecyclerAdapterPlayers(repositoriesListPresenter);

                recyclerView.setAdapter(adapterMenu1);
            }

            @Override
            public void onFailure(Call<ViewStatusPlayers> call, Throwable t) {
            }
        });


    }

    private String getToken(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }

}
