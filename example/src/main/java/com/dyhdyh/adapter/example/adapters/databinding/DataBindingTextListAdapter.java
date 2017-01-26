package com.dyhdyh.adapter.example.adapters.databinding;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapter.example.databinding.ItemDatabindingTextlistBinding;
import com.dyhdyh.adapters.databinding.DataBindingListAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingListHolder;

import java.util.List;

public class DataBindingTextListAdapter extends DataBindingListAdapter<String, ItemDatabindingTextlistBinding> {

    public DataBindingTextListAdapter(List<String> data) {
        super(data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_databinding_textlist;
    }

    @Override
    public void onBindViewHolder(DataBindingListHolder<ItemDatabindingTextlistBinding> holder, int position, String item) {
        holder.binding.setData(item);
    }


}
