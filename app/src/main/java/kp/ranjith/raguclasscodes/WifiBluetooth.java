package kp.ranjith.raguclasscodes;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class WifiBluetooth extends AppCompatActivity {

    Switch blu;
    Button wifibtn;
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(WifiBluetooth.this, "Permission denied to change bluetooth status", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_bluetooth);

        blu = findViewById(R.id.switch1);
        wifibtn = findViewById(R.id.btn);

        ActivityCompat.requestPermissions(WifiBluetooth.this,
                new String[]{Manifest.permission.BLUETOOTH_CONNECT},
                1);

        blu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if (isChecked) {
                    if (ActivityCompat.checkSelfPermission(WifiBluetooth.this, Manifest.permission.BLUETOOTH_CONNECT)
                            != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    mBluetoothAdapter.enable();
                } else {
                    mBluetoothAdapter.disable();
                }

            }
        });

        wifibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                Intent panel = new Intent(Settings.Panel.ACTION_WIFI);
                startActivity(panel);
            }
        });

     /*   wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);
                    startActivityForResult(panelIntent, 0);
                } else {
                    // add appropriate permissions to AndroidManifest file (see https://stackoverflow.com/questions/3930990/android-how-to-enable-disable-wifi-or-internet-connection-programmatically/61289575)
                    wifi.setWifiEnabled(true);
                }
            }
        });*/


    }
}
