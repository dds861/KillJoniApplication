package com.chatserver.dd.chat.Model.Activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatserver.dd.chat.Presenter.RepositoriesListPresenterAllWords;
import com.chatserver.dd.chat.View.Adapter.RecyclerAdapterAllWords;
import com.chatserver.dd.chat.Model.Retrofit.ConnectRetrofit;
import com.chatserver.dd.chat.View.Model.ModelChat;
import com.chatserver.dd.chat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityAllWords extends AppCompatActivity {

    RecyclerView recyclerView;
    View view;

    public ActivityAllWords(View view) {
        this.view = view;
    }

    public void getUserList() {

        //initializing Call
        ConnectRetrofit connectRetrofit = new ConnectRetrofit();
        Call<List<ModelChat>> call = connectRetrofit.getApiService().getAllWords();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMain);
        call.enqueue(new Callback<List<ModelChat>>() {
            @Override
            public void onResponse(Call<List<ModelChat>> call, Response<List<ModelChat>> response) {
                List<ModelChat> userList = response.body();
                LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(layoutManager);

                RepositoriesListPresenterAllWords repositoriesListPresenter = new RepositoriesListPresenterAllWords(userList);
                RecyclerAdapterAllWords adapterMenu1 = new RecyclerAdapterAllWords(repositoriesListPresenter);
                recyclerView.setAdapter(adapterMenu1);

            }

            @Override
            public void onFailure(Call<List<ModelChat>> call, Throwable t) {
            }
        });


    }


}
