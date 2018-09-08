package com.chatserver.dd.chat.Vip.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Vip.Model.Model;
import com.chatserver.dd.chat.Vip.Presenter.Presenter;

import java.util.List;

public class ActivityVip extends AppCompatActivity implements IView {

    private RecyclerView mRecyclerViewMain;
    private Presenter presenterAllWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        initView();

        presenterAllWords = new Presenter(this,new Model());
        presenterAllWords.requestDataFromServer();

        getUserList();
    }

    private void getUserList() {

    }

    RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(UsersVip usersAllWords) {
            Toast.makeText(ActivityVip.this,
                    "Message:  " + usersAllWords.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    };

    private void initView() {

        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recyclerViewMain);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataToRecyclerView(List<UsersVip> userList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityVip.this);
        mRecyclerViewMain.setLayoutManager(layoutManager);
        Adapter recyclerViewAdapter = new Adapter(userList,recyclerItemClickListener);
        mRecyclerViewMain.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }


}
