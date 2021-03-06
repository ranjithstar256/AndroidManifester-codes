package kp.ranjith.raguclasscodes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BroadcastReceiverExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_example);

        // this code is added in manifester file please check the <receiver > tag
        //in manifest file.
        // as per that code you will receive a toast message whenever we turn ON/OFF the
        // AIRPLANE MODE.
        // check out  MyReceiver class file
    }
}
