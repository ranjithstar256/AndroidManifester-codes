package kp.ranjith.raguclasscodes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Airplane Mood Turned ON/OFF", Toast.LENGTH_SHORT).show();

        // this block will be get executed when the airplane mode got turned ON/OFF
    }
}
