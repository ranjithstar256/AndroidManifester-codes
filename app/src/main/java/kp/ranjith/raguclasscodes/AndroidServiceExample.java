package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AndroidServiceExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_service_example);
    }

    public void startservce(View view) {

        Intent intent = new Intent(AndroidServiceExample.this,MyService.class);
        startService(intent);
    }

    public void stoptservce(View view) {

        Intent intent = new Intent(AndroidServiceExample.this,MyService.class);
        stopService(intent);
    }
}
