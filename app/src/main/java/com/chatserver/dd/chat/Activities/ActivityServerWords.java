package com.chatserver.dd.chat.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chatserver.dd.chat.APIService;
import com.chatserver.dd.chat.Adapter;
import com.chatserver.dd.chat.Model;
import com.chatserver.dd.chat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityServerWords extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private List<Model> userList = null;
    private RecyclerView recyclerView;
    private Call<List<Model>> call = null;

    Retrofit retrofit = null;
    String url;
    APIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_recycler_view);

        //Setting the url
        url = getString(R.string.website);

        //Initializing Retrofit with building it
        createRetrofit(url);

        //Initializing apiService
        apiService = retrofit.create(APIService.class);


        getUserList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserList();
            }
        });
    }

    private Retrofit createRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private void initializeCall(int temp) {

        call = apiService.getServerWords();
    }

    private void getUserList() {


        //получаем какое меню мы нажали
        Intent intent = getIntent();
        final int temp = intent.getIntExtra("id", 0);

        //initializing Call
        initializeCall(temp);


        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                userList = response.body();
                recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
                layoutManager = new LinearLayoutManager(ActivityServerWords.this);
                recyclerView.setLayoutManager(layoutManager);

                Adapter adapterMenu2 = new Adapter(getApplicationContext(), userList);

                recyclerView.setAdapter(adapterMenu2);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("123", t.getMessage());
            }
        });
    }
}
