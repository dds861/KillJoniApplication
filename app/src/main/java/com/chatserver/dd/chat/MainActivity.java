package com.chatserver.dd.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chatserver.dd.chat.Menu1.ActivityMenu1;
import com.chatserver.dd.chat.Menu2.ActivityMenu2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static com.chatserver.dd.chat.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    private Button mBtn1;
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        initView();


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3941279894802307/3018755401");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

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
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent intent1 = new Intent(this, ActivityMenu1.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent intent2 = new Intent(this, ActivityMenu2.class);
                startActivity(intent2);
                break;
        }
    }

//        productList.add(new Product("kill_joni JONI AST","46.174.48.29:27202",R.mipmap.ic_mansion));
//        productList.add(new Product("kill_joni Sho0teR-","46.174.48.42:27228",R.mipmap.ic_mansion));

}
