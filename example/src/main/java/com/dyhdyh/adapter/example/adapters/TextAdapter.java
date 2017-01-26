package com.dyhdyh.adapter.example.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapters.AbstractRecyclerAdapter;

import java.util.List;

public class TextAdapter extends AbstractRecyclerAdapter<String, TextAdapter.ItemViewHolder> {

    public TextAdapter(List<String> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position, String item) {
        holder.tv.setText(item);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false));
    }

    protected static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.tv);
        }
    }

}
