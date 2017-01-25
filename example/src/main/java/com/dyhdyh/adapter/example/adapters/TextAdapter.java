package com.dyhdyh.adapter.example.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapters.recyclerview.AbstractRecyclerAdapter;

import java.util.List;

public class TextAdapter extends AbstractRecyclerAdapter<String, TextAdapter.Holder> {

    public TextAdapter(List<String> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position, String item) {
        holder.tv.setText(item);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false));
    }

    protected static class Holder extends RecyclerView.ViewHolder {
        TextView tv;

        public Holder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
