package com.chatserver.dd.chat.allwords.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.chatserver.dd.chat.allwords.model.ModelAllWords;
import com.chatserver.dd.chat.allwords.presenter.PresenterAllWords;
import com.chatserver.dd.chat.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ActivityAllWords extends AppCompatActivity implements IViewAllWords {

    private RecyclerView mRecyclerViewMain;
    private PresenterAllWords presenterAllWords;
    private Disposable subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_words);
        initView();

        presenterAllWords = new PresenterAllWords(this, new ModelAllWords());

        onStartListenInputs();


    }

    private void onStartListenInputs() {
        subscription = Observable.interval(1000, 30000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        Log.i("autolog", "aLong: " + aLong);
                        presenterAllWords.requestDataFromServer();

                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.dispose();
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
