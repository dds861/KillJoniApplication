package com.chatserver.dd.chat;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

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
    Call<List<Model>> getAdminConnect();



}
