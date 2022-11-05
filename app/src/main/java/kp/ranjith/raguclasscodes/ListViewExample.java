package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewExample extends AppCompatActivity {

    ListView lv;

    //GridView gv;
    //Spinner sp;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        lv = findViewById(R.id.idlistv);

        //gv=(GridView)findViewById(R.id.gridview); // in the ui delete the listview add add gridview
        //sp=(Spinner)findViewById(R.id.spinner);   // in the ui delete the listview add add spinner

        arrayList=new ArrayList<>();
        arrayList.add("ranjith");
        arrayList.add("AndroidManifester");
        arrayList.add("ramu");
        arrayList.add("somu");
        arrayList.add("kumar");
        arrayList.add("rajesh");
        arrayList.add("suresh");
        arrayList.add("raju");
        arrayList.add("haran");
        arrayList.add("ranjith");
        arrayList.add("AndroidManifester");
        arrayList.add("siva");
        arrayList.add("ramu");
        arrayList.add("somu");
        arrayList.add("kumar");
        arrayList.add("ranjith");
        arrayList.add("AndroidManifester");
        arrayList.add("rajesh");
        arrayList.add("suresh");
        arrayList.add("raju");
        arrayList.add("haran");
        arrayList.add("siva");
        arrayList.add("ramu");
        arrayList.add("somu");
        arrayList.add("kumar");
        arrayList.add("rajesh");
        arrayList.add("suresh");
        arrayList.add("raju");
        arrayList.add("haran");
        arrayList.add("siva");

        arrayAdapter=new ArrayAdapter<String>(ListViewExample.this,android.R.layout.simple_list_item_1,arrayList);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListViewExample.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });

         //for gridview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewExample.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        /* // for spinner
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(ListViewExample.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
}
