package `in`.xiandan.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by xiandanin on 2021/1/12 14:42
 */
abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder>(data: List<T> = mutableListOf()) :
        RecyclerView.Adapter<VH>() {
    private var mData: List<T> = data

    protected var mOnItemClickListener: OnItemClickListener? = null
    protected var mItemLongClickListener: OnItemLongClickListener? = null

    open fun onCreateViewHolderFormLayoutId(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return BaseViewHolder(parent, onCreateViewHolderFormLayoutId()) as VH
    }

    abstract fun onBindViewHolder(holder: VH, position: Int, item: T?)

    final override fun onBindViewHolder(holder: VH, position: Int) {
        this.onBindViewHolder(holder, position, getItem(position))
        registerItemEvent(holder)
    }

    open fun onBindViewHolder(holder: VH, position: Int, item: T?, payloads: MutableList<Any>) {
        this.onBindViewHolder(holder, position)
    }

    final override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        this.onBindViewHolder(holder, position, getItem(position), payloads)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    open fun getItem(position: Int): T? {
        return data.getOrNull(position)
    }

    protected open fun registerItemEvent(holder: VH) {
        mOnItemClickListener?.apply {
            holder.itemView.setOnClickListener {
                onItemClick(this@BaseRecyclerAdapter, it, holder.layoutPosition)
            }
        }
        mItemLongClickListener?.apply {
            holder.itemView.setOnLongClickListener {
                return@setOnLongClickListener onItemLongClick(
                        this@BaseRecyclerAdapter,
                        it,
                        holder.layoutPosition
                )
            }
        }
    }

    var data: List<T>
        get() = mData
        set(value) {
            mData = value
        }

    open fun addItem(item: T) {
        (mData as MutableList?)?.apply {
            add(item)
            notifyItemInserted(size)
        }
    }

    open fun addItem(position: Int, item: T) {
        (mData as MutableList?)?.apply {
            add(position, item)
            notifyItemInserted(position)
        }
    }

    open fun addItemAll(collection: Collection<T>) {
        (mData as MutableList?)?.apply {
            val oldSize = mData.size
            addAll(collection)
            notifyItemRangeInserted(oldSize, collection.size)
        }
    }


    open fun addItemAll(position: Int, collection: Collection<T>) {
        (mData as MutableList?)?.apply {
            addAll(position, collection)
            notifyItemRangeInserted(position, collection.size)
        }
    }

    open fun removeItem(position: Int) {
        (mData as MutableList?)?.apply {
            removeAt(position)
            notifyItemRemoved(position)
            val itemCount = mData.size - position
            notifyItemRangeChanged(position, itemCount)
        }
    }

    open fun removeItemAll(collection: Collection<T>) {
        (mData as MutableList?)?.apply {
            removeAll(collection)
            notifyDataSetChanged()
        }
    }


    open fun clearRemoved() {
        (mData as MutableList?)?.apply {
            clear()
            notifyItemRangeRemoved(0, mData.size)
        }
    }

    open fun clear() {
        (mData as MutableList?)?.apply {
            clear()
            notifyDataSetChanged()
        }
    }

    open fun setOnItemClickListener(listener: (adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int) -> Unit) {
        mOnItemClickListener = object : OnItemClickListener {
            override fun onItemClick(adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int) {
                listener(adapter, view, position)
            }
        }
    }

    open fun setOnItemClickListener(listener: OnItemClickListener?) {
        mOnItemClickListener = listener
    }

    open fun setOnItemLongClickListener(listener: OnItemLongClickListener?) {
        mItemLongClickListener = listener
    }

    open fun setOnItemLongClickListener(listener: (adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int) -> Boolean) {
        mItemLongClickListener = object : OnItemLongClickListener {
            override fun onItemLongClick(adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int): Boolean {
                return listener(adapter, view, position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(adapter: BaseRecyclerAdapter<*, *>, view: View, position: Int): Boolean
    }

    interface OnItemChildClickListener {
        fun onItemChildClick(adapter: BaseRecyclerAdapter<*, *>, itemView: View, clickView: View, position: Int): Boolean
    }

}