package com.dyhdyh.adapters.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dyhdyh.adapters.AbstractRecyclerAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingRecyclerHolder;

import java.util.List;

/**
 * author  dengyuhan
 * created 2016/7/7 18:24
 */
public abstract class DataBindingRecyclerAdapter<T, B extends ViewDataBinding> extends AbstractRecyclerAdapter<T, DataBindingRecyclerHolder<B>> {

    public DataBindingRecyclerAdapter(List<T> data) {
        super(data);
    }

    @Override
    public DataBindingRecyclerHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataBindingRecyclerHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getItemLayoutId(), parent, false));
    }

    protected abstract int getItemLayoutId();

}
