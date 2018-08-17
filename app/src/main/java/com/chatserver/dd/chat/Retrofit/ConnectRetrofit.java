package com.chatserver.dd.chat.Retrofit;

import android.view.View;

import com.chatserver.dd.chat.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectRetrofit {

    Retrofit retrofit = null;
    String url;
    APIService apiService;

    View view;

    public ConnectRetrofit(View view) {
        this.view = view;
    }

   public APIService getApiService() {
        //Setting the url
        url = view.getResources().getString(R.string.website);
        //Initializing Retrofit with building it
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Initializing apiService
        apiService = retrofit.create(APIService.class);
        return apiService;
    }
   public APIService getApiServiceStatus() {
        //Setting the url
        url = view.getResources().getString(R.string.website2);
        //Initializing Retrofit with building it
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Initializing apiService
        apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
