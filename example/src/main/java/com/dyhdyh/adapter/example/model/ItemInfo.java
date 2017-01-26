package com.dyhdyh.adapter.example.model;

/**
 * author  dengyuhan
 * created 2017/1/26 21:37
 */
public class ItemInfo {
    private String content;
    private long time;
    private boolean showTime;
    private boolean isSelf;


    public ItemInfo(String content, boolean isSelf) {
        this.content = content;
        this.isSelf = isSelf;
    }

    public ItemInfo(long time) {
        this.showTime = true;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelf() {
        return isSelf;
    }

    public void setSelf(boolean self) {
        isSelf = self;
    }

    public boolean isShowTime() {
        return showTime;
    }

    public void setShowTime(boolean showTime) {
        this.showTime = showTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


}