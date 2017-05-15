package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        ListView lv;
        ArrayList<String> arrayList;
        ArrayAdapter<String> arrayAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view_example);
            lv= (ListView) findViewById(R.id.idlistv);
            arrayList=new ArrayList<String>();
            arrayList.add("Simple Button Click Event");
            arrayList.add("Getting data from EditText");
            arrayList.add("Passing Data Between Activity");
            arrayList.add("ListView Example");
            arrayList.add("Widgets Radio checkbox");
            arrayList.add("Date Time Picker");
            arrayList.add("Audio Video in Example");
            arrayList.add("Start Activity for Result Example");
            arrayList.add("Alert and Custom Dialogs");
            arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);

            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, "You have selected "+arrayList.get(position), Toast.LENGTH_SHORT).show();


                    switch (position){
                        case 0:
                            startActivity(new Intent(MainActivity.this,SimpleButtonClickEventListener.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this,GettingDatafromEditText.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this,PassingDataBwActivity.class));
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this,ListViewExample.class));
                            break;
                        case 4:
                            startActivity(new Intent(MainActivity.this,WidgetsRadioCheck.class));
                            break;
                        case 5:
                            startActivity(new Intent(MainActivity.this,DataTimePicker.class));
                            break;
                        case 6:
                            startActivity(new Intent(MainActivity.this,AudioVideoExample.class));
                            break;
                        case 7:
                            startActivity(new Intent(MainActivity.this,StartActivityForResultExample.class));
                            break;
                        case 8:
                            startActivity(new Intent(MainActivity.this,SimpleAlertDialog.class));
                            break;
                    }
                }
            });

        }
    }

