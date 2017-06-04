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
            arrayList.add("WebView Example");
            arrayList.add("Turn On Off Wifi Bluetooth");
            arrayList.add("Gmap Find current Location");
            arrayList.add("SharedPreference Example");

            arrayList.add("Notification Example");
            arrayList.add("Internal External Storage Example");
            arrayList.add("Activity Life Cycle Example");
            arrayList.add("Animation in Android");
            arrayList.add("Sending Sms and Mail");
            arrayList.add("Sensor Example");
            arrayList.add("Android Service");

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
                        case 9:
                            startActivity(new Intent(MainActivity.this,WebviewExample.class));
                            break;

                        case 10:
                            startActivity(new Intent(MainActivity.this,WifiBluetooth.class));
                            break;
                        case 11:
                            startActivity(new Intent(MainActivity.this,MapsActivity.class));
                            break;
                        case 12:
                            startActivity(new Intent(MainActivity.this,SharedPreferenceExample.class));
                            break;
                        case 13:
                            startActivity(new Intent(MainActivity.this,NotificationExample.class));
                            break;
                        case 14:
                            startActivity(new Intent(MainActivity.this,ActivityLifeCycleExample.class));
                            break;
                        case 15:
                            startActivity(new Intent(MainActivity.this,AnimationInAndroid.class));
                            break;
                        case 16:
                            startActivity(new Intent(MainActivity.this,SendingSmsMail.class));
                            break;
                        case 17:
                            startActivity(new Intent(MainActivity.this,SensorsInAndroid.class));
                            break;
                        case 18:
                            startActivity(new Intent(MainActivity.this,AndroidServiceExample.class));
                            break;
                    }
                }
            });

        }
    }

