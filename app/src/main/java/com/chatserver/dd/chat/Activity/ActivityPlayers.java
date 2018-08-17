package com.chatserver.dd.chat.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatserver.dd.chat.Adapter.AdapterPlayers;
import com.chatserver.dd.chat.Model.Model_Status_Players;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Retrofit.ConnectRetrofit;

import java.util.List;

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
        ConnectRetrofit connectRetrofit = new ConnectRetrofit(view);
        Call<Model_Status_Players> call = connectRetrofit.getApiServiceStatus().getPlayers("status", getToken(view.getContext()));

        call.enqueue(new Callback<Model_Status_Players>() {
            @Override
            public void onResponse(Call<Model_Status_Players> call, Response<Model_Status_Players> response) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPlayers);
                Model_Status_Players model_status = response.body();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);



                AdapterPlayers adapterMenu1 = new AdapterPlayers(view.getContext(), model_status);
                recyclerView.setAdapter(adapterMenu1);
            }

            @Override
            public void onFailure(Call<Model_Status_Players> call, Throwable t) {
            }
        });


    }

    private String getToken(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }

}
