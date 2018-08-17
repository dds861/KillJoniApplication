package com.chatserver.dd.chat.Retrofit;


import com.chatserver.dd.chat.Model.Model;
import com.chatserver.dd.chat.Model.ModelAdminConnect;
import com.chatserver.dd.chat.Model.Model_unknown;
import com.chatserver.dd.chat.Model.Model_Status_Players;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dd on 03.05.2017.
 */

public interface APIService {
    //url for "All" Words
    @GET("hlstats_Events_AllWords.php")
    Call<List<Model>> getAllWords();

    //url for "Server" Words
    @GET("hlstats_Events_ServerWords.php")
    Call<List<Model>> getServerWords();

    //url for "Vip" Words
    @GET("hlstats_Events_VipWords.php")
    Call<List<Model>> getVipWords();

    //url for "AdminConnect" Words
    @GET("hlstats_Events_adminConnect.php")
    Call<List<ModelAdminConnect>> getAdminConnect();


    //url for myarena Status
    @GET("api.php")
    Call<Model_Status_Players> getUserData(@Query("query") String query, @Query("token") String token);

    //url for myarena Status
    @GET("api.php")
    Call<Model_Status_Players> getPlayers(@Query("query") String query, @Query("token") String token);

    //kick
    @GET("api.php")
    Call<Model_unknown> getConsoleCmd(@Query("query") String query, @Query("cmd") String cmd, @Query("token") String token);;

    //Start
    @GET("api.php")
    Call<Model_unknown> getServerActions(@Query("query") String query, @Query("token") String token);


}
