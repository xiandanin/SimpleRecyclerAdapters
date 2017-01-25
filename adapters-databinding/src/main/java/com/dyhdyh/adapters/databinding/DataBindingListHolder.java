package com.dyhdyh.adapters.databinding;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.dyhdyh.adapters.adapterview.ViewHolder;

/**
 * author  dengyuhan
 * created 2016/8/9 11:28
 */
public class DataBindingListHolder<B extends ViewDataBinding> extends ViewHolder {
    public B binding;

    public DataBindingListHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public DataBindingListHolder(View v) {
        super(v);
    }
}
