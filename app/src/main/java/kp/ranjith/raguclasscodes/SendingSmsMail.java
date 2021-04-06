package kp.ranjith.raguclasscodes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SendingSmsMail extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5;
    String number, smsmsg, mailid, mailsub, mailmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_sms_mail);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText7);
        editText4 = findViewById(R.id.editText8);
        editText5 = findViewById(R.id.editText9);
        ActivityCompat.requestPermissions(SendingSmsMail.this,
                new String[]{Manifest.permission.SEND_SMS},
                1);
    }

    public void sendsms(View view) {
        number=editText1.getText().toString();
        smsmsg = editText2.getText().toString();
        sendsm(number, smsmsg);
        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }

    public void sendmail(View view) {
        mailid=editText3.getText().toString();
        mailsub=editText4.getText().toString();
        mailmsg=editText5.getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);


        email.putExtra(Intent.EXTRA_EMAIL, new String[]{mailid});
        email.putExtra(Intent.EXTRA_SUBJECT, mailsub);
        email.putExtra(Intent.EXTRA_TEXT, mailmsg);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :")); // no permission needed for mail
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
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
                    Toast.makeText(SendingSmsMail.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void sendsm(String n, String m) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(n, null, m, null, null); //we need to add permission in manifest file to send sms
    }
}
