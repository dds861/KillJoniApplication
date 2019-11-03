package com.chatserver.dd.chat.Mvp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chatserver.dd.chat.Admins.View.ActivityAdmins;
import com.chatserver.dd.chat.AllWords.View.ActivityAllWords;
import com.chatserver.dd.chat.Cmd.View.ActivityCmd;
import com.chatserver.dd.chat.R;
import com.chatserver.dd.chat.Server.View.ActivityServer;
import com.chatserver.dd.chat.Vip.View.ActivityVip;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mAllWordsBtn;
    private Button mServerBtn;
    private Button mVipBtn;
    private Button mAdminsBtn;
    private Button mStatusBtn;
    private Button mPlayersBtn;
    private Button mMessageBtn;
    private Button mCmdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();


    }

    private void initView() {
        mAllWordsBtn = (Button) findViewById(R.id.btn_AllWords);
        mAllWordsBtn.setOnClickListener(this);
        mServerBtn = (Button) findViewById(R.id.btn_Server);
        mServerBtn.setOnClickListener(this);
        mVipBtn = (Button) findViewById(R.id.btn_Vip);
        mVipBtn.setOnClickListener(this);
        mAdminsBtn = (Button) findViewById(R.id.btn_Admins);
        mAdminsBtn.setOnClickListener(this);
        mCmdBtn = (Button) findViewById(R.id.btn_Cmd);
        mCmdBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_AllWords:
                // TODO 18/09/06
                intent = new Intent(getApplicationContext(), ActivityAllWords.class);
                startActivity(intent);
                break;
            case R.id.btn_Server:
                // TODO 18/09/06
                intent = new Intent(getApplicationContext(), ActivityServer.class);
                startActivity(intent);
                break;
            case R.id.btn_Vip:
                // TODO 18/09/06
                intent = new Intent(getApplicationContext(), ActivityVip.class);
                startActivity(intent);
                break;
            case R.id.btn_Admins:
                // TODO 18/09/06
                intent = new Intent(getApplicationContext(), ActivityAdmins.class);
                startActivity(intent);
                break;
//            case R.id.btn_Status:
//                 TODO 18/09/06
//                break;
//            case R.id.btn_Players:
//                 TODO 18/09/06
//                break;
//            case R.id.btn_Message:
//                 TODO 18/09/06
//                break;
            case R.id.btn_Cmd:// TODO 18/09/10
                intent = new Intent(getApplicationContext(), ActivityCmd.class);
                startActivity(intent);
                break;
            default:
                break;

        }

    }
}
