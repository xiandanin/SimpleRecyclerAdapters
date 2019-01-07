package com.dyhdyh.adapters.holder;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author dengyuhan
 * created 2019/1/7 14:46
 */
public abstract class ObjectViewHolder<T> extends BaseViewHolder implements BindViewHolder<T> {
    public ObjectViewHolder(int layoutId, ViewGroup parent) {
        super(layoutId, parent);
    }

    public ObjectViewHolder(View itemView) {
        super(itemView);
    }
}
