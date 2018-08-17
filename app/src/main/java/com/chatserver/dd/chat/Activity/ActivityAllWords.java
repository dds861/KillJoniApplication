package com.chatserver.dd.chat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatserver.dd.chat.Adapter.Adapter;
import com.chatserver.dd.chat.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.Model.Model;
import com.chatserver.dd.chat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityAllWords extends AppCompatActivity {

    RecyclerView recyclerView;
    View view;

    public ActivityAllWords(View view) {
        this.view = view;
    }

    public void getUserList() {

        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit(view);
        Call<List<Model>> call = connectRetrofit.getApiService().getAllWords();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMain);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> userList = response.body();
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);
                Adapter adapterMenu1 = new Adapter(view.getContext(), userList);
                recyclerView.setAdapter(adapterMenu1);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
            }
        });


    }


}
