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
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent1 = new Intent(this, ActivityMenu1.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this, ActivityMenu2.class);
                startActivity(intent2);
                break;
        }
    }

//        productList.add(new Product("kill_joni JONI AST","46.174.48.29:27202",R.mipmap.ic_mansion));
//        productList.add(new Product("kill_joni Sho0teR-","46.174.48.42:27228",R.mipmap.ic_mansion));

}