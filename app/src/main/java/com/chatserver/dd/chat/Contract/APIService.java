package com.chatserver.dd.chat.Contract;


import com.chatserver.dd.chat.Admins.View.UsersAdmins;
import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd;
import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers;
import com.chatserver.dd.chat.Server.View.UsersServer;
import com.chatserver.dd.chat.Vip.View.UsersVip;
import com.chatserver.dd.chat.allwords.view.UsersAllWords;

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
    Call<List<UsersAllWords>> getAllWords();

    //url for "Server" Words
    @GET("hlstats_Events_ServerWords.php")
    Call<List<UsersServer>> getServerWords();

    //url for "Vip" Words
    @GET("hlstats_Events_VipWords.php")
    Call<List<UsersVip>> getVipWords();

    //url for "AdminConnect" Words
    @GET("hlstats_Events_adminConnect.php")
    Call<List<UsersAdmins>> getAdminConnect();


    //url for myarena Status
    @GET("api.php")
    Call<ViewStatusPlayers> getUserData(@Query("query") String query, @Query("token") String token);

    //url for myarena ViewMessage
    @GET("api.php")
    Call<ViewStatusPlayers> getPlayers2(@Query("query") String query, @Query("token") String token);

    //kick
    @GET("api.php")
    Call<ViewConsoleCmd> getConsoleCmd(@Query("query") String query, @Query("cmd") String cmd, @Query("token") String token);

    //Start
    @GET("api.php")
    Call<ViewConsoleCmd> getServerActions(@Query("query") String query, @Query("token") String token);


}
