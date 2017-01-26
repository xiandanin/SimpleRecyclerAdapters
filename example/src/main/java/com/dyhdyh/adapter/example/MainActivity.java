package com.dyhdyh.adapter.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * author  dengyuhan
 * created 2017/1/26 16:06
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 通用的Adapter例子
     * @param v
     */
    public void clickAdapter(View v){
        startActivity(new Intent(this,GeneralActivity.class));
    }

    /**
     * 支持DataBinding的通用Adapter例子
     * @param v
     */
    public void clickDataBindingAdapter(View v){
        startActivity(new Intent(this,DataBindingActivity.class));
    }

    /**
     * 多样式的RecyclerView Adapter
     * @param v
     */
    public void clickMultifyRecyclerAdapter(View v){
        startActivity(new Intent(this,MultifyActivity.class));
    }

    /**
     * 多样式的List Adapter
     * @param v
     */
    public void clickMultifyListAdapter(View v){
        startActivity(new Intent(this,MultifyListActivity.class));
    }


    /**
     * 支持DataBinding多样式的RecyclerView Adapter
     * @param v
     */
    public void clickDataBindingMultifyRecyclerAdapter(View v){
        startActivity(new Intent(this,DataBindingMultifyActivity.class));
    }

    /**
     * 支持DataBinding多样式的List Adapter
     * @param v
     */
    public void clickDataBindingMultifyListAdapter(View v){
        startActivity(new Intent(this,DataBindingMultifyListActivity.class));
    }



}
