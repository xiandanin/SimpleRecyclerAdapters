package com.dyhdyh.adapters.databinding;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.dyhdyh.adapters.BaseRecyclerAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingRecyclerHolder;

import java.util.List;

/**
 * author  dengyuhan
 * created 2016/7/7 18:24
 */
public abstract class DataBindingRecyclerAdapter<T, B extends ViewDataBinding> extends BaseRecyclerAdapter<T, DataBindingRecyclerHolder<B>> {

    public DataBindingRecyclerAdapter(List<T> data) {
        super(data);
    }

    @Override
    public DataBindingRecyclerHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataBindingRecyclerHolder(getItemLayoutId(), parent);
    }

    protected abstract int getItemLayoutId();

}
