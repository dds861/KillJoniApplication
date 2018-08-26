package com.chatserver.dd.chat.Model.Retrofit;

import android.support.v7.app.AppCompatActivity;

import com.chatserver.dd.chat.Contract.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectRetrofit extends AppCompatActivity {

    public APIService getApiService() {
        //Setting the url
        String url = "http://killjoniast.myarena.ru/android/";
        //Initializing Retrofit with building it

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Initializing apiService
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }

    public APIService getApiServiceMyarena() {
        //Setting the url
        String url = "https://www.myarena.ru/";
        //Initializing Retrofit with building it
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Initializing apiService
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
