package com.chatserver.dd.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chatserver.dd.chat.Menu1.ActivityMenu1;
import com.chatserver.dd.chat.Menu2.ActivityMenu2;

import static com.chatserver.dd.chat.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Buttons on MainAcitivity
    private Button mBtn1;
    private Button mBtn2;

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
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.btn1:


                //open new Activity
                Intent intent1 = new Intent(this, ActivityMenu1.class);
                startActivity(intent1);


                break;

            case R.id.btn2:

                //open new Activity
                Intent intent2 = new Intent(this, ActivityMenu2.class);
                startActivity(intent2);

                break;
        }
    }
}
