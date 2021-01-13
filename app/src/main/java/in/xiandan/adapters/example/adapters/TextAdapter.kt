package `in`.xiandan.adapters.example.adapters

import `in`.xiandan.adapters.BaseRecyclerAdapter
import `in`.xiandan.adapters.BaseViewHolder
import `in`.xiandan.adapters.example.R
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_text.view.*

/**
 * Created by xiandanin on 2021/1/12 15:07
 */
class TextAdapter(data:List<String>) : BaseRecyclerAdapter<String, BaseViewHolder>(data) {
    override fun onCreateViewHolderFormLayoutId(): Int {
        return R.layout.item_text
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, item: String?) {
        holder.itemView.tv.setText(item)
    }



}