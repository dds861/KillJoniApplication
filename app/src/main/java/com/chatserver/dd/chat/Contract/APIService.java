package com.chatserver.dd.chat.Contract;


import com.chatserver.dd.chat.View.Model.ModelChat;
import com.chatserver.dd.chat.View.Model.ModelAdminConnect;
import com.chatserver.dd.chat.View.Model.ModelConsoleCmd;
import com.chatserver.dd.chat.View.Model.ModelStatusPlayers;

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
    Call<List<ModelChat>> getAllWords();

    //url for "Server" Words
    @GET("hlstats_Events_ServerWords.php")
    Call<List<ModelChat>> getServerWords();

    //url for "Vip" Words
    @GET("hlstats_Events_VipWords.php")
    Call<List<ModelChat>> getVipWords();

    //url for "AdminConnect" Words
    @GET("hlstats_Events_adminConnect.php")
    Call<List<ModelAdminConnect>> getAdminConnect();


    //url for myarena Status
    @GET("api.php")
    Call<ModelStatusPlayers> getUserData(@Query("query") String query, @Query("token") String token);

    //url for myarena Status
    @GET("api.php")
    Call<ModelStatusPlayers> getPlayers(@Query("query") String query, @Query("token") String token);

    //kick
    @GET("api.php")
    Call<ModelConsoleCmd> getConsoleCmd(@Query("query") String query, @Query("cmd") String cmd, @Query("token") String token);

    //Start
    @GET("api.php")
    Call<ModelConsoleCmd> getServerActions(@Query("query") String query, @Query("token") String token);


}
