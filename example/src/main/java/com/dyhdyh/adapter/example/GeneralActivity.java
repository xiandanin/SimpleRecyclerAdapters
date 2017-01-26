package com.dyhdyh.adapter.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dyhdyh.adapter.example.adapters.TextAdapter;
import com.dyhdyh.adapter.example.adapters.TextListAdapter;
import com.dyhdyh.adapters.AbstractRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


public class GeneralActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ListView lv;

    private TextAdapter textAdapter;
    private TextListAdapter textListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        rv= (RecyclerView) findViewById(R.id.rv);
        lv= (ListView) findViewById(R.id.lv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //普通RecyclerView Adapter
        textAdapter =new TextAdapter(DataUtils.getTextData());
        //ItemClick
        textAdapter.setOnItemClickListener(new AbstractRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AbstractRecyclerAdapter adapter, View view, int position) {
                Toast.makeText(GeneralActivity.this, "Click "+adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        //ItemLongClick
        textAdapter.setOnItemLongClickListener(new AbstractRecyclerAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AbstractRecyclerAdapter adapter, View view, int position) {
                Toast.makeText(GeneralActivity.this, "Long Click "+adapter.getItem(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        rv.setAdapter(textAdapter);

        //普通ListView Adapter
        textListAdapter=new TextListAdapter(DataUtils.getTextData());
        lv.setAdapter(textListAdapter);
        //ItemClick
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GeneralActivity.this, "Click "+parent.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        //ItemLongClick
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GeneralActivity.this, "Long Click "+parent.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    /**
     * 添加Item
     * @param item
     */
    public void clickAddItem(MenuItem item){
        textAdapter.addItem(0,"Add Item "+textAdapter.getItemCount());
        textListAdapter.addItem(0,"Add Item "+textListAdapter.getCount());
    }

    /**
     * 添加多个Item
     * @param item
     */
    public void clickAddAllItem(MenuItem item){
        List<String> add=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            add.add("Add Item All "+(textAdapter.getItemCount()+i));
        }

        textAdapter.addItemAll(0,add);
        textListAdapter.addItemAll(0,add);
    }

    /**
     * 删除Item
     * @param item
     */
    public void clickRemoveItem(MenuItem item){
        textAdapter.removeItem(0);
        textListAdapter.removeItem(0);
    }

    /**
     * 删除多个Item
     * @param item
     */
    public void clickRemoveAllItem(MenuItem item){
        List<String> remove=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            remove.add(textAdapter.getItem(i));
        }

        textAdapter.removeItemAll(remove);
        textListAdapter.removeItemAll(remove);
    }

    /**
     * 清空
     * @param item
     */
    public void clickClearItem(MenuItem item){
        textAdapter.clear();
        textListAdapter.clear();
    }
}
