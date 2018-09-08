package com.chatserver.dd.chat.Mvp.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.chatserver.dd.chat.R;

public class MyarenaToken {

    Context context;

    public MyarenaToken(Context context) {
        this.context = context;
    }


    public String getToken() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("token", null);
    }

    public void setToken() {
        //saving token to memory
        String token = context.getString(R.string.token);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.apply();

    }

}
