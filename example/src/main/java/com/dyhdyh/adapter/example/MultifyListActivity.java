package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dyhdyh.adapter.example.adapters.MultifyListAdapter;

public class MultifyListActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);


        lv= (ListView) findViewById(R.id.lv);

        MultifyListAdapter multifyListAdapter =new MultifyListAdapter(DataUtils.getMultifyData());
        lv.setAdapter(multifyListAdapter);
    }

}
