package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import kp.ranjith.s3_v2_viewmodeldemo.MainActivity2;

public class MainActivity extends AppCompatActivity {
//This is example
        ListView lv;
        ArrayList<String> arrayList;
        ArrayAdapter<String> arrayAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view_example);
            lv = findViewById(R.id.idlistv);


            arrayList=new ArrayList<String>();
            arrayList.add("Simple Button Click Event and Menu Example");//0
            arrayList.add("Getting data from EditText");//1
            arrayList.add("Passing Data Between Activity");//2
            arrayList.add("ListView Example");//3
            arrayList.add("Widgets Radio checkbox");//4
            arrayList.add("Date Time Picker");//5
            arrayList.add("Audio Video in Example");//6
            arrayList.add("Start Activity for Result Example");//7
            arrayList.add("Alert and Custom Dialogs");//8
            arrayList.add("WebView Example");//9
            arrayList.add("Turn On Off Wifi Bluetooth");//10
            arrayList.add("Gmap Find current Location");//11
            arrayList.add("SharedPreference Example");//12
            arrayList.add("Notification Example");//13
            arrayList.add("Internal External Storage Example");//14
            arrayList.add("Activity Life Cycle Example");//15
            arrayList.add("Animation in Android");//16
            arrayList.add("Sending Sms and Mail");//17
            arrayList.add("Sensor Example");//18
            arrayList.add("Android Service");//19
            arrayList.add("Fragment Example");//20
            arrayList.add("Fragment with Navigation");//21
            arrayList.add("SQLite Database! CURD operation");//22
            arrayList.add("Internet Based App - Getting data from API/URL using REST API");//23
            arrayList.add("RecyclerView");//24
            arrayList.add("Retrofit Example");//25
            arrayList.add("Ola Uber Swiggy\nLive location\nTracking");//26
            arrayList.add("Work Manager Example");//27
            arrayList.add("Simple ROOM Database Example");//28
            arrayList.add("Livedata Example");//29
            arrayList.add("MVVM Example");//30


            arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, "You have selected " + arrayList.get(position), Toast.LENGTH_SHORT).show();


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
                            startActivity(new Intent(MainActivity.this, MapsExpl.class));
                            break;
                        case 12:
                            startActivity(new Intent(MainActivity.this,SharedPreferenceExample.class));
                            break;
                        case 13:
                            startActivity(new Intent(MainActivity.this,NotificationExample.class));
                            break;
                        case 14:
                            startActivity(new Intent(MainActivity.this,InternalExternalStorage.class));
                            break;
                        case 15:
                            startActivity(new Intent(MainActivity.this,ActivityLifeCycleExample.class));
                            break;
                        case 16:
                            startActivity(new Intent(MainActivity.this,AnimationInAndroid.class));
                            break;
                        case 17:
                            startActivity(new Intent(MainActivity.this,SendingSmsMail.class));
                            break;
                        case 18:
                            startActivity(new Intent(MainActivity.this,SensorsInAndroid.class));
                            break;
                        case 19:
                            startActivity(new Intent(MainActivity.this,AndroidServiceExample.class));
                            break;
                        case 20:
                            startActivity(new Intent(MainActivity.this,FragmentsExample.class));

                            break;
                        case 21:
                            startActivity(new Intent(MainActivity.this, NavigationActivity.class));
                            break;
                        case 22:
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            break;
                        case 23:
                            startActivity(new Intent(MainActivity.this, WebBased.class));
                            break;
                        case 24:
                            startActivity(new Intent(MainActivity.this, ReCycleViewExpl.class));
                            break;
                        case 25:
                            startActivity(new Intent(MainActivity.this, SimpleRetrofitExpl.class));
                            break;

                        case 26:
                            startActivity(new Intent(MainActivity.this, GmapLiveTracking.class));
                            Toast.makeText(MainActivity.this, "it will keep updating when your location changes", Toast.LENGTH_LONG).show();
                            break;



                        case 27:
                            startActivity(new Intent(MainActivity.this, WorkMngrExpl.class));
                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
                            break;

                        case 28:
                            startActivity(new Intent(MainActivity.this, kp.ranjith.notesroom.MainActivity.class));
                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
                            break;

                        case 29:
                            startActivity(new Intent(MainActivity.this, MainActivity2.class));
                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
                            break;

                        case 30:
                            startActivity(new Intent(MainActivity.this, kp.ranjith.s3_v2_viewmodeldemo.MainActivity.class));
                            Toast.makeText(MainActivity.this, "even if rotate the device , data is not lost", Toast.LENGTH_LONG).show();
                            break;

                        // content provider example
                        // firebase examples (all whatever is possible)

                    }
                }
            });

        }
    }

