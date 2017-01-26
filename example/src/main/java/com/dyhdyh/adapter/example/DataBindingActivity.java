package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.dyhdyh.adapter.example.adapters.databinding.DataBindingTextAdapter;
import com.dyhdyh.adapter.example.adapters.databinding.DataBindingTextListAdapter;


public class DataBindingActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        rv= (RecyclerView) findViewById(R.id.rv);
        lv= (ListView) findViewById(R.id.lv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //普通RecyclerView Adapter
        DataBindingTextAdapter textAdapter =new DataBindingTextAdapter(DataUtils.getDBTextData());
        rv.setAdapter(textAdapter);

        //普通ListView Adapter
        DataBindingTextListAdapter textListAdapter=new DataBindingTextListAdapter(DataUtils.getDBTextData());
        lv.setAdapter(textListAdapter);
    }

}
