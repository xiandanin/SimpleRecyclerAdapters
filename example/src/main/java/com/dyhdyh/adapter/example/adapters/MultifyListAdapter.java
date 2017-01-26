package com.dyhdyh.adapter.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapter.example.model.ItemInfo;
import com.dyhdyh.adapters.AbstractListAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 多布局ListAdapter
 * author  dengyuhan
 * created 2017/1/26 22:12
 */
public class MultifyListAdapter extends AbstractListAdapter<ItemInfo, AbstractListAdapter.ViewHolder> {
    private static final int VIEWTYPE_FROM = 1;
    private static final int VIEWTYPE_TO = 0;
    private static final int VIEWTYPE_TIME = 2;

    private SimpleDateFormat format=new SimpleDateFormat("HH:mm");


    public MultifyListAdapter(List<ItemInfo> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(AbstractListAdapter.ViewHolder holder, int position, ItemInfo item) {
        int viewType = getItemViewType(position);
        switch (viewType){
            case VIEWTYPE_TIME:
                ((TimeViewHolder) holder).tv_time.setText(format.format(item.getTime()));
                break;
            case VIEWTYPE_TO:
                ((ToViewHolder) holder).tv_to_content.setText(item.getContent());
                break;
            case VIEWTYPE_FROM:
                ((FromViewHolder) holder).tv_from_content.setText(item.getContent());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        ItemInfo item = getData().get(position);
        //如果让显示时间
        if (item.isShowTime()){
            return VIEWTYPE_TIME;
        }else{
            //如果是自己发的
            if (item.isSelf()) {
                return VIEWTYPE_TO;
            } else {
                return VIEWTYPE_FROM;
            }
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public AbstractListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==VIEWTYPE_TIME){
            return new TimeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multify_time,null));
        }else if (viewType == VIEWTYPE_FROM) {
            return new FromViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_databinding_multify_from,null));
        } else {
            return new ToViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multify_to,null));
        }

    }

    protected static class ToViewHolder extends AbstractListAdapter.ViewHolder {
        private TextView tv_to_content;

        public ToViewHolder(View itemView) {
            super(itemView);
            tv_to_content = (TextView) itemView.findViewById(R.id.tv_to_content);
        }
    }

    protected static class FromViewHolder extends AbstractListAdapter.ViewHolder {

        private TextView tv_from_content;

        public FromViewHolder(View itemView) {
            super(itemView);
            tv_from_content = (TextView) itemView.findViewById(R.id.tv_from_content);
        }
    }


    protected static class TimeViewHolder extends AbstractListAdapter.ViewHolder {

        private TextView tv_time;

        public TimeViewHolder(View itemView) {
            super(itemView);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }

}
