package com.chatserver.dd.chat.Admins.Model;


import com.chatserver.dd.chat.Admins.View.UsersAdmins;
import com.chatserver.dd.chat.Contract.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelAdmins implements IModelAdmins {
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
            Call<List<UsersAdmins>> call = service.getAdminConnect();

            call.enqueue(new Callback<List<UsersAdmins>>() {
                @Override
                public void onResponse(Call<List<UsersAdmins>> call, Response<List<UsersAdmins>> response) {

                    onFinishedListener.resultsOnRequest(response.body());

                }

                @Override
                public void onFailure(Call<List<UsersAdmins>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }


}
