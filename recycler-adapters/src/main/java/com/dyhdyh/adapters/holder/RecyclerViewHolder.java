package com.dyhdyh.adapters.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author dengyuhan
 *         created 2018/5/7 15:30
 */
public abstract class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public RecyclerViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    public abstract void onBindViewHolder(int position, T item);
}