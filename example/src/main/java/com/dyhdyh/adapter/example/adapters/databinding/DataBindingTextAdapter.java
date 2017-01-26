package com.dyhdyh.adapter.example.adapters.databinding;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapter.example.databinding.ItemDatabindingTextBinding;
import com.dyhdyh.adapters.databinding.DataBindingRecyclerAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingRecyclerHolder;

import java.util.List;

public class DataBindingTextAdapter extends DataBindingRecyclerAdapter<String, ItemDatabindingTextBinding> {

    public DataBindingTextAdapter(List<String> data) {
        super(data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_databinding_text;
    }

    @Override
    public void onBindViewHolder(DataBindingRecyclerHolder<ItemDatabindingTextBinding> holder, int position, String item) {
        holder.binding.setData(item);
    }


}
