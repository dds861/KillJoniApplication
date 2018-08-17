package com.chatserver.dd.chat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatserver.dd.chat.Adapter.AdapterAdminConnect;
import com.chatserver.dd.chat.Model.ModelAdminConnect;
import com.chatserver.dd.chat.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityAdminConnect2 extends AppCompatActivity {

    ;
    View view;

    public ActivityAdminConnect2(View view) {
        this.view = view;
    }

    public void getUserList() {

        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit(view);
        Call<List<ModelAdminConnect>> call = connectRetrofit.getApiService().getAdminConnect();

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMain);
        call.enqueue(new Callback<List<ModelAdminConnect>>() {
            @Override
            public void onResponse(Call<List<ModelAdminConnect>> call, Response<List<ModelAdminConnect>> response) {
                List<ModelAdminConnect> userList = response.body();
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);
                AdapterAdminConnect adapterMenu1 = new AdapterAdminConnect(view.getContext(), userList);
                recyclerView.setAdapter(adapterMenu1);
            }

            @Override
            public void onFailure(Call<List<ModelAdminConnect>> call, Throwable t) {
            }
        });


    }


}
