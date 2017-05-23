package com.dyhdyh.adapters;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author  dengyuhan
 * created 2017/1/26 14:42
 */
public abstract class AbstractRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private List<T> mData;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;

    public AbstractRecyclerAdapter(List<T> data) {
        this.mData = data == null ? new ArrayList<T>() : data;
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        T item;
        try {
            item = mData.get(position);
        } catch (IndexOutOfBoundsException e) {
            item = null;
        }
        this.onBindViewHolder(holder, position, item);
        if (holder.itemView != null) {
            if (mOnItemClickListener != null) {
                holder.itemView.setOnClickListener(new OnItemClickListenerImpl(this, position));
            }
            if (mItemLongClickListener != null) {
                holder.itemView.setOnLongClickListener(new OnItemLongClickListenerImpl(this, position));
            }
        }
    }

    public abstract void onBindViewHolder(VH holder, int position, T item);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 获取条目数据
     *
     * @param position 要获取的对象在适配器中的位置
     * @return position位置的对象
     */
    public T getItem(int position) {
        return mData.get(position);
    }

    /**
     * 添加一个条目
     *
     * @param item 要添加的数据
     */
    public void addItem(T item) {
        mData.add(item);
        notifyItemInserted(mData.size() - 1);
    }

    /**
     * 添加一个条目到position位置
     *
     * @param position 指定的位置
     * @param item     要添加的数据
     */
    public void addItem(int position, T item) {
        mData.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * 添加多个条目
     *
     * @param collection 要添加的数据集合
     */
    public void addItemAll(Collection<? extends T> collection) {
        int oldSize = mData.size();
        mData.addAll(collection);
        notifyItemRangeInserted(oldSize, collection.size());
    }

    /**
     * 添加多个条目到position位置
     *
     * @param position   指定的位置
     * @param collection 要添加的数据集合
     */
    public void addItemAll(int position, Collection<? extends T> collection) {
        mData.addAll(position, collection);
        notifyItemRangeInserted(position, collection.size());
    }

    /**
     * 删除一个条目
     * <p>为了避免notifyItemRemoved后导致position错乱,所以再调用notifyItemRangeChanged刷新position</p>
     *
     * @param position 要删除的位置
     */
    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }


    /**
     * 删除多个条目
     *
     * @param collection 要删除的数据集合
     */
    public void removeItemAll(Collection<? extends T> collection) {
        mData.removeAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 清空适配器数据
     */
    public void clear() {
        mData.clear();
        //notifyDataSetChanged();
        notifyItemRangeRemoved(0, mData.size());
    }


    public List<T> getData() {
        return mData;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mItemLongClickListener = onItemLongClickListener;
    }


    /**
     * 条目点击
     */
    public interface OnItemClickListener {
        void onItemClick(AbstractRecyclerAdapter adapter, View view, int position);
    }

    /**
     * 条目长按
     */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AbstractRecyclerAdapter adapter, View view, int position);
    }


    protected static class OnItemClickListenerImpl implements View.OnClickListener {
        private AbstractRecyclerAdapter mAdapter;
        private int mPosition;

        public OnItemClickListenerImpl(AbstractRecyclerAdapter adapter, int position) {
            this.mAdapter = adapter;
            this.mPosition = position;
        }

        @Override
        public void onClick(View v) {
            mAdapter.mOnItemClickListener.onItemClick(mAdapter, v, mPosition);
        }
    }

    protected static class OnItemLongClickListenerImpl implements View.OnLongClickListener {
        private AbstractRecyclerAdapter mAdapter;
        private int mPosition;

        public OnItemLongClickListenerImpl(AbstractRecyclerAdapter adapter, int position) {
            this.mAdapter = adapter;
            this.mPosition = position;
        }

        @Override
        public boolean onLongClick(View v) {
            return mAdapter.mItemLongClickListener.onItemLongClick(mAdapter, v, mPosition);
        }
    }


    public static abstract class RecyclerHolder<T> extends RecyclerView.ViewHolder {

        public RecyclerHolder(View itemView) {
            super(itemView);
        }

        public RecyclerHolder(ViewGroup parent, @LayoutRes int layoutId) {
            this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        }

        public abstract void onBindViewHolder(int position, T item);
    }
}
