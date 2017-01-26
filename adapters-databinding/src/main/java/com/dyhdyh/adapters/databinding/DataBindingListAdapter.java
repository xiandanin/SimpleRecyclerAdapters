package com.dyhdyh.adapters.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dyhdyh.adapters.AbstractListAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingListHolder;

import java.util.List;

/**
 * author  dengyuhan
 * created 2016/7/7 18:24
 */
public abstract class DataBindingListAdapter<T, B extends ViewDataBinding> extends AbstractListAdapter<T, DataBindingListHolder<B>> {

    public DataBindingListAdapter(List<T> data) {
        super(data);
    }

    @Override
    public DataBindingListHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataBindingListHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getItemLayoutId(), parent, false));
    }

    protected abstract int getItemLayoutId();

}
