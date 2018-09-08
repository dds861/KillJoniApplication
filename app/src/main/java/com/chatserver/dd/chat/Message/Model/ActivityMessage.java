package com.chatserver.dd.chat.Message.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class ActivityMessage extends AppCompatActivity {
    View view;
    public ActivityMessage(View view) {
        this.view = view;
    }
    public void getPlayersList() {
        //initializing Call
//        ConnectRetrofit connectRetrofit = new ConnectRetrofit(view);
//        Call<ModelStatusPlayers> call = connectRetrofit.getApiServiceMyarena().getPlayers("status", getToken(view.getContext()));
//        call.enqueue(new Callback<ModelStatusPlayers>() {
//            @Override
//            public void onResponse(Call<ModelStatusPlayers> call, Response<ModelStatusPlayers> response) {
//                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMessagePlayers);
//                ModelStatusPlayers model_status = response.body();
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
//                recyclerView.setLayoutManager(layoutManager);
//                RadioGroup radioGroup = view.findViewById(R.id.rbgMessage);
//                EditText editText = view.findViewById(R.id.edMessage);
//                AdapterPlayers adapterMenu1 = new AdapterPlayers(view.getContext(), model_status,radioGroup,editText);
//                recyclerView.setAdapter(adapterMenu1);
//            }
//            @Override
//            public void onFailure(Call<ModelStatusPlayers> call, Throwable t) {
//            }
//        });
    }
    private String getToken(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString("token", null);
        return token;
    }
}
