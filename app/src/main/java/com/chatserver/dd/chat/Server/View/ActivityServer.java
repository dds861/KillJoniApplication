package com.chatserver.dd.chat.Server.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Server.Model.ModelServer;
import com.chatserver.dd.chat.Server.Presenter.PresenterServer;

import java.util.List;

public class ActivityServer extends AppCompatActivity implements IViewServer {

    private RecyclerView mRecyclerViewMain;
    private PresenterServer presenterAllWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        initView();

        presenterAllWords = new PresenterServer(this,new ModelServer());
        presenterAllWords.requestDataFromServer();

        getUserList();
    }

    private void getUserList() {

    }

    RecyclerItemClickListenerServer recyclerItemClickListener = new RecyclerItemClickListenerServer() {
        @Override
        public void onItemClick(UsersServer usersAllWords) {
            Toast.makeText(ActivityServer.this,
                    "Message:  " + usersAllWords.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    };

    private void initView() {

        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recyclerViewMain);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataToRecyclerView(List<UsersServer> userList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityServer.this);
        mRecyclerViewMain.setLayoutManager(layoutManager);
        AdapterServer recyclerViewAdapter = new AdapterServer(userList,recyclerItemClickListener);
        mRecyclerViewMain.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }


}
