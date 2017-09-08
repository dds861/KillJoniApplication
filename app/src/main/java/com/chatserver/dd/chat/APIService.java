package com.chatserver.dd.chat;


import com.chatserver.dd.chat.Menu1.UserMenu1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dd on 03.05.2017.
 */

public interface APIService {
    //url for Chat
    @GET("hlstats_Events_Chat.php")
    Call<List<UserMenu1>> getUserDataChat();



}
