package com.chatserver.dd.chat.AllWords.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chatserver.dd.chat.AllWords.Model.ModelAllWords;
import com.chatserver.dd.chat.AllWords.Presenter.PresenterAllWords;
import com.chatserver.dd.chat.R;

import java.util.List;

public class ActivityAllWords extends AppCompatActivity implements IViewAllWords {

    private RecyclerView mRecyclerViewMain;
    private PresenterAllWords presenterAllWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_words);
        initView();

        presenterAllWords = new PresenterAllWords(this,new ModelAllWords());
        presenterAllWords.requestDataFromServer();

    }

    private void initView() {

        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recyclerViewMain);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataToRecyclerView(List<UsersAllWords> userList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityAllWords.this);
        mRecyclerViewMain.setLayoutManager(layoutManager);
        AdapterAllWords recyclerViewAdapter = new AdapterAllWords(userList);
        mRecyclerViewMain.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }


}
