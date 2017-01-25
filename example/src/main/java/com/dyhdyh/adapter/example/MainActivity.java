package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.dyhdyh.adapter.example.adapter.recyclerview.TextAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv= (RecyclerView) findViewById(R.id.rv);
        lv= (ListView) findViewById(R.id.lv);

        List<String> data = getTestData();
        TextAdapter textAdapter=new TextAdapter(data);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setAdapter(new RecyclerViewAdapterWrapper(textAdapter));
    }

    private List<String> getTestData(){
        List<String> data=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add("Item "+i);
        }
        return data;
    }
}
