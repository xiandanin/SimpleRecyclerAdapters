package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyhdyh.adapter.example.adapters.MultifyAdapter;

public class MultifyActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);


        rv= (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        MultifyAdapter multifyAdapter =new MultifyAdapter(DataUtils.getMultifyData());
        rv.setAdapter(multifyAdapter);
    }

}
