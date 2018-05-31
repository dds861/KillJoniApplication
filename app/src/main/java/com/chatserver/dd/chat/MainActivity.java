package com.chatserver.dd.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chatserver.dd.chat.Activities.ActivityAllWords;
import com.chatserver.dd.chat.Activities.ActivityServerWords;
import com.chatserver.dd.chat.Activities.ActivityVipWords;

import static com.chatserver.dd.chat.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Buttons on MainAcitivity
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        initView();


    }

    private void initView() {
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent1 = null;
        switch (v.getId()) {
            case R.id.btn1:

                //open new Activity
                intent1 = new Intent(this, ActivityAllWords.class);
                break;

            case R.id.btn2:

                //open new Activity
                intent1 = new Intent(this, ActivityServerWords.class);
                break;

            case R.id.btn3:// TODO 18/05/31

                //open new Activity
                intent1 = new Intent(this, ActivityVipWords.class);
                break;
        }
        startActivity(intent1);
    }
}
