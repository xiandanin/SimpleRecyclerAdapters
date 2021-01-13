package in.xiandan.adapters.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

import in.xiandan.adapters.BaseRecyclerAdapter;
import in.xiandan.adapters.example.R;
import in.xiandan.adapters.example.model.ItemInfo;

/**
 * 多布局RecyclerAdapter
 * author  xiandanin
 * created 2017/1/26 22:12
 */
public class MultifyAdapter extends BaseRecyclerAdapter<ItemInfo, RecyclerView.ViewHolder> {
    private static final int VIEWTYPE_FROM = 1;
    private static final int VIEWTYPE_TO = 0;
    private static final int VIEWTYPE_TIME = 2;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");


    public MultifyAdapter(List<ItemInfo> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @Nullable ItemInfo item) {
        if (holder instanceof TimeViewHolder) {
            ((TimeViewHolder) holder).tv_time.setText(format.format(item.getTime()));
        } else if (holder instanceof FromViewHolder) {
            ((FromViewHolder) holder).tv_from_content.setText(item.getContent());
        } else {
            ((ToViewHolder) holder).tv_to_content.setText(item.getContent());
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEWTYPE_TIME) {
            return new TimeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multify_time, parent, false));
        } else if (viewType == VIEWTYPE_FROM) {
            return new FromViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multify_from, parent, false));
        } else {
            return new ToViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multify_to, parent, false));
        }

    }

    protected static class ToViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_to_content;

        public ToViewHolder(View itemView) {
            super(itemView);
            tv_to_content = (TextView) itemView.findViewById(R.id.tv_to_content);
        }
    }

    protected static class FromViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_from_content;

        public FromViewHolder(View itemView) {
            super(itemView);
            tv_from_content = (TextView) itemView.findViewById(R.id.tv_from_content);
        }
    }


    protected static class TimeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_time;

        public TimeViewHolder(View itemView) {
            super(itemView);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }

}
