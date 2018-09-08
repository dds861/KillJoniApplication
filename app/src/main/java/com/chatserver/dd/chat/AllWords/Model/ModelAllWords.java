package com.chatserver.dd.chat.AllWords.Model;


import com.chatserver.dd.chat.AllWords.View.UsersAllWords;
import com.chatserver.dd.chat.Contract.APIService;

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
            String url = "http://killjoniast.myarena.ru/android/";

            Retrofit retrofit = null;

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
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

                }
            });
        } catch (Exception e) {

        }


    }


}
