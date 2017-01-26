package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyhdyh.adapter.example.adapters.databinding.DataBindingMultifyAdapter;

public class DataBindingMultifyActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);


        rv= (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        DataBindingMultifyAdapter dataBindingMultifyAdapter =new DataBindingMultifyAdapter(DataUtils.getMultifyData());
        rv.setAdapter(dataBindingMultifyAdapter);
    }

}
