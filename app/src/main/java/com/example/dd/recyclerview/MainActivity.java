package com.example.dd.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter = new MyAdapter(this,productList);
        recyclerView.setAdapter(myAdapter);
    }

    private void setInitialData(){
        productList.add(new Product("kill_joni JONI AST","46.174.48.29:27202",R.mipmap.ic_mansion));
        productList.add(new Product("kill_joni Sho0teR-","46.174.48.42:27228",R.mipmap.ic_mansion));

    }
}
