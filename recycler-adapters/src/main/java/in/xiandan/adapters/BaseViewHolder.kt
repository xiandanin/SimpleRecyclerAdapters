package `in`.xiandan.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by xiandanin on 2021/1/12 14:43
 */
open class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(parent: ViewGroup, @LayoutRes layoutId: Int) : super(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

    constructor(itemView: View) : super(itemView)

}