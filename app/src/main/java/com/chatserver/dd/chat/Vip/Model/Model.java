package com.chatserver.dd.chat.Vip.Model;


import com.chatserver.dd.chat.Contract.APIService;
import com.chatserver.dd.chat.Vip.View.UsersVip;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements IModel {
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
            Call<List<UsersVip>> call = service.getVipWords();

            call.enqueue(new Callback<List<UsersVip>>() {
                @Override
                public void onResponse(Call<List<UsersVip>> call, Response<List<UsersVip>> response) {

                    onFinishedListener.onFinished(response.body());

                }

                @Override
                public void onFailure(Call<List<UsersVip>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }


}
