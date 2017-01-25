package com.dyhdyh.adapters.databinding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author  dengyuhan
 * created 2016/8/9 11:28
 */
public class DataBindingRecyclerHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public B binding;

    public DataBindingRecyclerHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public DataBindingRecyclerHolder(View v) {
        super(v);
    }
}
