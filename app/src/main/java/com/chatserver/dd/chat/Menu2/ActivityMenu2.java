package com.chatserver.dd.chat.Menu2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chatserver.dd.chat.APIService;
import com.chatserver.dd.chat.Menu1.AdapterMenu1;
import com.chatserver.dd.chat.Menu1.UserMenu1;
import com.chatserver.dd.chat.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ActivityMenu2 extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private List<UserMenu1> userList = null;
    private RecyclerView recyclerView;
    private Call<List<UserMenu1>> call = null;

    Retrofit retrofit = null;
    String url;
    APIService apiService;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_recycler_view);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Setting the url
        url = "http://shooter.myarena.ru/android/";

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

        call = apiService.getUserDataChat();
    }

    private void getUserList() {


        //получаем какое меню мы нажали
        Intent intent = getIntent();
        final int temp = intent.getIntExtra("id", 0);

        //initializing Call
        initializeCall(temp);


        call.enqueue(new Callback<List<UserMenu1>>() {
            @Override
            public void onResponse(Call<List<UserMenu1>> call, Response<List<UserMenu1>> response) {

                userList = response.body();
                recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
                layoutManager = new LinearLayoutManager(com.chatserver.dd.chat.Menu2.ActivityMenu2.this);
                recyclerView.setLayoutManager(layoutManager);

                AdapterMenu1 adapterMenu1 = new AdapterMenu1(getApplicationContext(), userList);

                recyclerView.setAdapter(adapterMenu1);
            }

            @Override
            public void onFailure(Call<List<UserMenu1>> call, Throwable t) {
                Log.d("123", t.getMessage());
            }
        });
    }
}
