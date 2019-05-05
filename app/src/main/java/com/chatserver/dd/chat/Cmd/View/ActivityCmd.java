package com.chatserver.dd.chat.Cmd.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chatserver.dd.chat.Cmd.Model.ModelCmd;
import com.chatserver.dd.chat.Cmd.Presenter.PresenterCmd;
import com.chatserver.dd.chat.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ActivityCmd extends AppCompatActivity implements IViewCmd, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RecyclerView mRecyclerViewMain;
    private PresenterCmd presenterCmd;
    private RadioButton mRbPlayersKick;
    private RadioButton mRbPlayersSlap;
    private RadioButton mRbPlayersSlay;
    private RadioGroup radioGroup;

    private Button mSendBtn;
    private EditText mEtTextCommands;
    private FloatingActionButton mBtnCmdFl;
    private RadioButton mAmxChatRb;
    private RadioButton mAmxPsayRb;
    private RadioButton mAmxSayRb;
    private CardView mCmdCommandsCv;
    private Button mClearEdittextBtn;
    private CardView mEdittextCv;
    private CardView mPlayersTopBarsCv;
    private RadioButton mRbPlayersBan;
    private RadioButton mAmxBanipRb;
    private RadioButton mRbPlayersGag;
    private RadioButton mAmxSetfragsRb;
    private RadioButton mAmxSetdeathsRb;
    private RadioButton mAmxReloadadminsRb;
    private RadioButton mAmxNickRb;
    private RelativeLayout mEdittextRelativeLayout;
    private Disposable subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmd);
        initView();

        presenterCmd = new PresenterCmd(this, new ModelCmd());



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
                        presenterCmd.requestDataFromServer();

                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.dispose();
    }

    private void initView() {

        mRecyclerViewMain = (RecyclerView) findViewById(R.id.recyclerViewPlayers);
        mRbPlayersKick = (RadioButton) findViewById(R.id.rbPlayersKick);
        mRbPlayersSlap = (RadioButton) findViewById(R.id.rbPlayersSlap);
        mRbPlayersSlay = (RadioButton) findViewById(R.id.rbPlayersSlay);

        mAmxChatRb = (RadioButton) findViewById(R.id.rb_amx_chat);
        mAmxPsayRb = (RadioButton) findViewById(R.id.rb_amx_psay);
        mAmxSayRb = (RadioButton) findViewById(R.id.rb_amx_say);
        mEtTextCommands = (EditText) findViewById(R.id.etTextCommands);
        mRbPlayersBan = (RadioButton) findViewById(R.id.rbPlayersBan);
        mAmxBanipRb = (RadioButton) findViewById(R.id.rb_amx_banip);
        mRbPlayersGag = (RadioButton) findViewById(R.id.rbPlayersGag);
        mAmxSetfragsRb = (RadioButton) findViewById(R.id.rb_amx_setfrags);
        mAmxSetdeathsRb = (RadioButton) findViewById(R.id.rb_amx_setdeaths);
        mAmxReloadadminsRb = (RadioButton) findViewById(R.id.rb_amx_reloadadmins);
        mAmxNickRb = (RadioButton) findViewById(R.id.rb_amx_nick);

        radioGroup = (RadioGroup) findViewById(R.id.rb_groupPlayers);
        radioGroup.setOnCheckedChangeListener(this);

        mSendBtn = (Button) findViewById(R.id.btn_send);
        mSendBtn.setOnClickListener(this);

        mBtnCmdFl = (FloatingActionButton) findViewById(R.id.fl_btn_cmd);
        mBtnCmdFl.setOnClickListener(this);

        mClearEdittextBtn = (Button) findViewById(R.id.btn_clear_edittext);
        mClearEdittextBtn.setOnClickListener(this);

        //не нужные можно удалить
        mEdittextRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout_edittext);
        mCmdCommandsCv = (CardView) findViewById(R.id.cv_cmd_commands);
        mEdittextCv = (CardView) findViewById(R.id.cv_edittext);
        mPlayersTopBarsCv = (CardView) findViewById(R.id.cv_players_top_bars);


    }

    @Override
    public void setDataToRecyclerView(ViewStatusPlayers dataToRecyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityCmd.this);
        mRecyclerViewMain.setLayoutManager(layoutManager);
        AdapterCmd recyclerViewAdapter = new AdapterCmd(dataToRecyclerView, presenterCmd);
        mRecyclerViewMain.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setEdittext(String playerName) {
        mEtTextCommands.setText(playerName);
    }

    @Override
    public String getEdittext() {
        return String.valueOf(mEtTextCommands.getText());
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                // TODO 18/09/10
                presenterCmd.onExecuteCmd(String.valueOf(mEtTextCommands.getText()));
                presenterCmd.onRefreshButtonClick();
                break;
            case R.id.fl_btn_cmd:// TODO 18/09/11
                presenterCmd.onRefreshButtonClick();
                break;
            case R.id.btn_clear_edittext:// TODO 18/09/11
                mEtTextCommands.setText("");
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String playerName = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        presenterCmd.onSetCmdToEditText(playerName);
    }


}
