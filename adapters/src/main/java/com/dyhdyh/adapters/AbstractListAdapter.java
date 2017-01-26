package com.dyhdyh.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * author  dengyuhan
 * created 2017/1/25 20:40
 */
public abstract class AbstractListAdapter<T,VH extends AbstractListAdapter.ViewHolder> extends BaseAdapter{
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

    /**
     * 添加一个条目
     *
     * @param item 要添加的数据
     */
    public void addItem(T item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    /**
     * 添加一个条目到position位置
     *
     * @param position 指定的位置
     * @param item 要添加的数据
     */
    public void addItem(int position, T item) {
        mData.add(position, item);
        notifyDataSetChanged();
    }

    /**
     * 添加多个条目
     *
     * @param collection 要添加的数据集合
     */
    public void addItemAll(Collection<? extends T> collection) {
        mData.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 添加多个条目到position位置
     *
     * @param position 指定的位置
     * @param collection 要添加的数据集合
     */
    public void addItemAll(int position, Collection<? extends T> collection) {
        mData.addAll(position, collection);
        notifyDataSetChanged();
    }

    /**
     * 删除一个条目
     *
     * @param position 要删除的位置
     */
    public void removeItem(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }


    /**
     * 删除多个条目
     *
     * @param collection 要删除的数据集合
     */
    public void removeItemAll(Collection<? extends T> collection) {
        mData.removeAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 清空适配器数据
     */
    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }



    /**
     * author  dengyuhan
     * created 2017/1/25 20:48
     */
    public static class ViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }





}