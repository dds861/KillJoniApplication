package com.chatserver.dd.chat.Other;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyarenaToken {

    Context context;

    public MyarenaToken(Context context) {
        this.context = context;
    }


    public String getToken() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }
}
