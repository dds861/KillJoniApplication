package com.chatserver.dd.chat.allwords.model;


import android.util.Log;

import com.chatserver.dd.chat.Contract.APIService;
import com.chatserver.dd.chat.allwords.view.UsersAllWords;
import com.chatserver.dd.chat.constants.ConstantsApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelAllWords implements IModelAllWords {
    ;

    @Override
    public void getArrayList(final OnFinishedListener onFinishedListener) {


        try {

            Retrofit retrofit = null;

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(ConstantsApp.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }


            APIService service = retrofit.create(APIService.class);
            Call<List<UsersAllWords>> call = service.getAllWords();

            call.enqueue(new Callback<List<UsersAllWords>>() {
                @Override
                public void onResponse(Call<List<UsersAllWords>> call, Response<List<UsersAllWords>> response) {

                    onFinishedListener.onFinished(response.body());

                }

                @Override
                public void onFailure(Call<List<UsersAllWords>> call, Throwable t) {
                    Log.i("autolog", "t.getMessage: " + t.getMessage());

                }
            });
        } catch (Exception e) {

        }


    }


}
