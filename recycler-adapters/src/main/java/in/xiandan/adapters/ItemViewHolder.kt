package `in`.xiandan.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by xiandanin on 2021/1/12 14:43
 */
abstract class ItemViewHolder<T> : BaseViewHolder {
    constructor(parent: ViewGroup, layoutId: Int) : super(parent, layoutId)
    constructor(itemView: View) : super(itemView)

    abstract fun onBind(position: Int, item: T?)
}