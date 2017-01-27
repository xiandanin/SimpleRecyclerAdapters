package com.dyhdyh.adapter.example.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapters.AbstractRecyclerAdapter;

import java.util.List;

public class SimpleAdapter extends AbstractRecyclerAdapter<String, SimpleAdapter.ItemViewHolder> {

    public SimpleAdapter(List<String> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position, String item) {

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false));
    }

    protected static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
