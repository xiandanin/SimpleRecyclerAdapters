package com.dyhdyh.adapter.example.adapters.databinding;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dyhdyh.adapter.example.R;
import com.dyhdyh.adapter.example.databinding.ItemDatabindingMultifyFromBinding;
import com.dyhdyh.adapter.example.databinding.ItemDatabindingMultifyTimeBinding;
import com.dyhdyh.adapter.example.databinding.ItemDatabindingMultifyToBinding;
import com.dyhdyh.adapter.example.model.ItemInfo;
import com.dyhdyh.adapters.AbstractListAdapter;
import com.dyhdyh.adapters.databinding.holder.DataBindingListHolder;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * DataBinding多布局List Adapter
 * author  dengyuhan
 * created 2017/1/26 22:12
 */
public class DataBindingMultifyListAdapter extends AbstractListAdapter<ItemInfo, DataBindingListHolder> {
    private static final int VIEWTYPE_FROM = 1;
    private static final int VIEWTYPE_TO = 0;
    private static final int VIEWTYPE_TIME = 2;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");


    public DataBindingMultifyListAdapter(List<ItemInfo> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(DataBindingListHolder holder, int position, ItemInfo item) {
        if (holder.binding instanceof ItemDatabindingMultifyToBinding){
            ((ItemDatabindingMultifyToBinding) holder.binding).setItem(item);
        }else if (holder.binding instanceof ItemDatabindingMultifyFromBinding){
            ((ItemDatabindingMultifyFromBinding) holder.binding).setItem(item);
        }else if (holder.binding instanceof ItemDatabindingMultifyTimeBinding){
            ((ItemDatabindingMultifyTimeBinding) holder.binding).setTime(format.format(item.getTime()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        ItemInfo item = getData().get(position);
        //如果让显示时间
        if (item.isShowTime()) {
            return VIEWTYPE_TIME;
        } else {
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
    public DataBindingListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;
        if (viewType == VIEWTYPE_TIME) {
            layoutId = R.layout.item_databinding_multify_time;
        } else if (viewType == VIEWTYPE_FROM) {
            layoutId = R.layout.item_databinding_multify_from;
        } else {
            layoutId = R.layout.item_databinding_multify_to;
        }
        return new DataBindingListHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false));
    }


}
