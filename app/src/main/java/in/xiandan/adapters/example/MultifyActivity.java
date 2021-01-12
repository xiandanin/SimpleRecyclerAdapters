package in.xiandan.adapters.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.xiandan.adapters.example.adapters.MultifyAdapter;

public class MultifyActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);


        rv= (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        MultifyAdapter multifyAdapter =new MultifyAdapter(DataUtils.getMultifyData());
        rv.setAdapter(multifyAdapter);
    }

}
