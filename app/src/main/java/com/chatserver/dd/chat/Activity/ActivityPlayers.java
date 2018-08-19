package com.chatserver.dd.chat.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.chatserver.dd.chat.Adapter.AdapterPlayers;
import com.chatserver.dd.chat.Model.ModelStatusPlayers;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Retrofit.ConnectRetrofit;

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
        Call<ModelStatusPlayers> call = connectRetrofit.getApiServiceMyarena().getPlayers("status", getToken(view.getContext()));

        call.enqueue(new Callback<ModelStatusPlayers>() {
            @Override
            public void onResponse(Call<ModelStatusPlayers> call, Response<ModelStatusPlayers> response) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPlayers);
                ModelStatusPlayers model_status = response.body();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                RadioGroup radioGroup = view.findViewById(R.id.rbgPlayers);
                EditText editText = view.findViewById(R.id.etTextCommands);

                AdapterPlayers adapterMenu1 = new AdapterPlayers(view.getContext(), model_status,radioGroup,editText);
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

}
