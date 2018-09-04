package kp.ranjith.raguclasscodes;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class WifiBluetooth extends AppCompatActivity {

    Switch blu;
    ToggleButton wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_bluetooth);

        blu= (Switch) findViewById(R.id.switch1);
        wifi= (ToggleButton) findViewById(R.id.toggleButton);


        blu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if(isChecked){
                mBluetoothAdapter.enable();
                }else {
                mBluetoothAdapter.disable();
                }

            }
        });

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                WifiManager wifi =(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if(isChecked){

                    wifi.setWifiEnabled(true);
                }
                else {
                    wifi.setWifiEnabled(false);
                }
            }
        });

        
        
        <!--Phone dial-->
        <Entry x:Name="MsgTo" Placeholder="PhoneNumber" HorizontalOptions="FillAndExpand"/>
        <Entry x:Name="Message" Placeholder="MessageText" HorizontalOptions="FillAndExpand"/>
        <Button Text="SMS"   Clicked="BtnSend_Click" BackgroundColor="White"/>

        <!--SMS-->
        <Entry x:Name="PhoneNumber" Placeholder="PhoneNumber" HorizontalOptions="FillAndExpand"/>
        <Button Text="CALL"  Clicked="BtnCall_Click" BackgroundColor="White"/>

        <!--Email-->
        <Entry x:Name="EmailTo" Placeholder="EmailTo" HorizontalOptions="FillAndExpand"/>
        <Entry x:Name="EmailSubject" Placeholder="Subject" HorizontalOptions="FillAndExpand"/>
        <Entry x:Name="EmailBody" Placeholder="MessageText" HorizontalOptions="FillAndExpand"/>
        <Button Text="EMAIL" Clicked="BtnEmail_Click" BackgroundColor="White"/>

		
		
		
		
		
		
		
		
		
		
		
		
        private void BtnSend_Click(object sender, EventArgs e)
        {

            var SmsTask = CrossMessaging.Current.SmsMessenger;

            if (SmsTask.CanSendSms)
                SmsTask.SendSms(MsgTo.Text, Message.Text);
        }


        private void BtnCall_Click(object sender, EventArgs e)
        {
            var PhoneCallTask = CrossMessaging.Current.PhoneDialer;
            if (PhoneCallTask.CanMakePhoneCall)
                PhoneCallTask.MakePhoneCall(PhoneNumber.Text);
        }


        private void BtnEmail_Click(object sender, EventArgs e)
        {
            var EmailTask = CrossMessaging.Current.EmailMessenger;

            if (EmailTask.CanSendEmail)
                EmailTask.SendEmail(EmailTo.Text, EmailSubject.Text, EmailBody.Text);
        }

		
        

    }
}
