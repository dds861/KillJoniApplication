package com.chatserver.dd.chat.Model.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.chatserver.dd.chat.Model.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterPlayers;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.View.Adapter.RecyclerAdapterPlayers;
import com.chatserver.dd.chat.View.Model.ModelStatusPlayers;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityMessage {

    View view;

    public ActivityMessage(View view) {
        this.view = view;
    }

    public void setPlayersList() {


        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit();
        Call<ModelStatusPlayers> call = connectRetrofit.getApiServiceMyarena().getPlayers("status", getToken(view.getContext()));

        call.enqueue(new Callback<ModelStatusPlayers>() {
            @Override
            public void onResponse(Call<ModelStatusPlayers> call, Response<ModelStatusPlayers> response) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMessagePlayers);
                ModelStatusPlayers model_status = response.body();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                RadioGroup mRbgMessage = view.findViewById(R.id.rbgMessage);
                EditText mEdMessage = view.findViewById(R.id.edMessage);
                Button btnSendMessage = view.findViewById(R.id.btn_sendMessage);


                RepositoriesListPresenterPlayers repositoriesListPresenter = new RepositoriesListPresenterPlayers(model_status);

                RecyclerAdapterPlayers adapterMenu1 = new RecyclerAdapterPlayers(repositoriesListPresenter);

                recyclerView.setAdapter(adapterMenu1);

                btnSendMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
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
