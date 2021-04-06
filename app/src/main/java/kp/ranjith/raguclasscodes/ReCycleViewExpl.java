package kp.ranjith.raguclasscodes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReCycleViewExpl extends AppCompatActivity {

    int img;
    String re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_cycle_view_expl);

        MyListData[] myListData = new MyListData[]{
                new MyListData(re, img),
        };

        RecyclerView recyclerView = findViewById(R.id.re);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}