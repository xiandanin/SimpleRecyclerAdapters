package `in`.xiandan.adapters.example

import `in`.xiandan.adapters.BaseRecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 通用的Adapter例子
     * @param v
     */
    fun clickAdapter(v: View?) {
        startActivity(Intent(this, GeneralActivity::class.java))
    }

    /**
     * 多样式的RecyclerView Adapter
     * @param v
     */
    fun clickMultifyRecyclerAdapter(v: View?) {
        startActivity(Intent(this, MultifyActivity::class.java))
    }


}