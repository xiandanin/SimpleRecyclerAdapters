package com.dyhdyh.adapters.adapterview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author  dengyuhan
 * created 2017/1/25 20:40
 */
public abstract class AbstractListAdapter<T,VH extends ViewHolder> extends BaseAdapter{
    private List<T> mData;

    public AbstractListAdapter(List<T> data) {
        this.mData = data == null ? new ArrayList<T>() : data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH holer;
        if (convertView == null) {
            holer = onCreateViewHolder(parent,getItemViewType(position));
            convertView = holer.itemView;
            convertView.setTag(holer);
        } else {
            holer = (VH) convertView.getTag();
        }
        T item;
        try {
            item = mData.get(position);
        } catch (IndexOutOfBoundsException e) {
            item = null;
        }
        this.onBindViewHolder(holer, position,item);
        return convertView;
    }



    public abstract VH onCreateViewHolder(ViewGroup parent,int viewType);

    public abstract void onBindViewHolder(VH holder, int position, T item);

    public int getItemViewType(int position) {
        return 0;
    }

    /**
     * 添加一个条目
     *
     * @param item
     */
    public void addItem(T item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    /**
     * 添加一个条目到position位置
     *
     * @param position
     * @param item
     */
    public void addItem(int position, T item) {
        mData.add(position, item);
        notifyDataSetChanged();
    }

    /**
     * 添加多个条目
     *
     * @param collection
     */
    public void addItemAll(Collection<? extends T> collection) {
        mData.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 添加多个条目到position位置
     *
     * @param position
     * @param collection
     */
    public void addItemAll(int position, Collection<? extends T> collection) {
        mData.addAll(position, collection);
        notifyDataSetChanged();
    }

    /**
     * 删除一个条目
     *
     * @param position
     */
    public void removeItem(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }


    /**
     * 删除多个条目
     *
     * @param collection
     */
    public void removeItemAll(Collection<? extends T> collection) {
        mData.removeAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 清空适配器数据
     *
     * @desc
     */
    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }


}