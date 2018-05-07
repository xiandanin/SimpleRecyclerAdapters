package com.dyhdyh.adapter.example.adapters;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapters.BaseRecyclerAdapter;
import com.dyhdyh.adapters.holder.BaseViewHolder;

import java.util.List;

public class TextAdapter extends BaseRecyclerAdapter<String, TextAdapter.ItemViewHolder> {

    public TextAdapter(List<String> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position, String item) {
        holder.tv.setText(item);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(R.layout.item_text, parent);
    }

    protected static class ItemViewHolder extends BaseViewHolder {
        private TextView tv;

        public ItemViewHolder(int layoutId, ViewGroup parent) {
            super(layoutId, parent);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
