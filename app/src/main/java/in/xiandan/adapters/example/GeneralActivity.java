package in.xiandan.adapters.example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.xiandan.adapters.BaseRecyclerAdapter;
import in.xiandan.adapters.example.adapters.TextAdapter;


public class GeneralActivity extends AppCompatActivity {

    private RecyclerView rv;

    private TextAdapter textAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //普通RecyclerView Adapter
        textAdapter = new TextAdapter(DataUtils.getTextData());
        //ItemClick
        textAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseRecyclerAdapter adapter, View view, int position) {
                Toast.makeText(GeneralActivity.this, "Click " + position + " : " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        //ItemLongClick
        textAdapter.setOnItemLongClickListener(new BaseRecyclerAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseRecyclerAdapter adapter, View view, int position) {
                Toast.makeText(GeneralActivity.this, "Long Click " + position + " : " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        rv.setAdapter(textAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 添加Item
     *
     * @param item
     */
    public void clickAddItem(MenuItem item) {
        textAdapter.addItem(0, "Add Item " + textAdapter.getItemCount());
    }

    /**
     * 添加多个Item
     *
     * @param item
     */
    public void clickAddAllItem(MenuItem item) {
        List<String> add = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            add.add("Add Item All " + (textAdapter.getItemCount() + i));
        }

        textAdapter.addItemAll(0, add);
    }

    /**
     * 删除Item
     *
     * @param item
     */
    public void clickRemoveItem(MenuItem item) {
        textAdapter.removeItem(0);
    }

    /**
     * 删除多个Item
     *
     * @param item
     */
    public void clickRemoveAllItem(MenuItem item) {
        List<String> remove = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            remove.add(textAdapter.getItem(i));
        }

        textAdapter.removeItemAll(remove);
    }

    /**
     * 清空
     *
     * @param item
     */
    public void clickClearItem(MenuItem item) {
        textAdapter.clear();
    }
}
