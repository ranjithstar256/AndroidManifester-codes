package kp.ranjith.raguclasscodes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReCycleViewExpl extends AppCompatActivity {

    //int img;
    ///String re;
    RecyclerView re;
    ArrayList<String> arrayList;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_cycle_view_expl);

        re= findViewById(R.id.re);
        arrayList= new ArrayList<>();
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        arrayList.add("bhelo"); arrayList.add("dhelo"); arrayList.add("ahelo"); arrayList.add("ahelo");arrayList.add("ahggelo");arrayList.add("heloggas");
        re.setLayoutManager(new LinearLayoutManager(ReCycleViewExpl.this));

        adapter= new MyRecyclerViewAdapter(this,arrayList);
        re.setAdapter(adapter);



     /*   MyListData[] myListData = new MyListData[]{
                new MyListData(re, img),
        };

        RecyclerView recyclerView = findViewById(R.id.re);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
   */ }
}