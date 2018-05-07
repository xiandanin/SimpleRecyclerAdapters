package com.dyhdyh.adapters.databinding.holder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author  dengyuhan
 * created 2016/8/9 11:28
 */
public class DataBindingRecyclerHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public B binding;

    public DataBindingRecyclerHolder(@LayoutRes int layoutId, ViewGroup parent) {
        this(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false));
    }

    public DataBindingRecyclerHolder(B binding) {
        this(binding.getRoot());
        this.binding = binding;
    }

    public DataBindingRecyclerHolder(View v) {
        super(v);
    }

}
