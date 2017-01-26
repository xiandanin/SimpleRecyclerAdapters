package com.dyhdyh.adapter.example;

import com.dyhdyh.adapter.example.model.ItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * author  dengyuhan
 * created 2017/1/26 16:04
 */
public class DataUtils {


    public static List<String> getTextData(){
        List<String> data=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("Item "+i);
        }
        return data;
    }


    public static List<String> getDBTextData(){
        List<String> data=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add("DataBinding Item "+i);
        }
        return data;
    }


    public static List<ItemInfo> getMultifyData(){
        List<ItemInfo> data=new ArrayList<>();
        data.add(new ItemInfo("鞋子会掉色吗....",true));
        data.add(new ItemInfo("???",true));
        data.add(new ItemInfo("会的哦",false));
        data.add(new ItemInfo("好的呢",true));
        data.add(new ItemInfo("恩恩",false));
        data.add(new ItemInfo("祝您生意兴隆呢",true));
        data.add(new ItemInfo("好的哦",false));
        data.add(new ItemInfo("谢谢的呢",false));
        data.add(new ItemInfo(System.currentTimeMillis()));
        data.add(new ItemInfo("坦白说了吧",false));
        data.add(new ItemInfo("我是假货",false));
        data.add(new ItemInfo("纳尼!",true));
        data.add(new ItemInfo("真的",false));
        data.add(new ItemInfo("假货",false));
        data.add(new ItemInfo("不是代购吗",true));
        data.add(new ItemInfo("不是",false));
        data.add(new ItemInfo("我店全部假货",false));
        data.add(new ItemInfo("你为啥要告诉我",true));
        data.add(new ItemInfo("我老实",false));
        return data;
    }
}