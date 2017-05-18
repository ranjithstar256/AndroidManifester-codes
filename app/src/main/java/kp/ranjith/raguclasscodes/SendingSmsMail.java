package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendingSmsMail extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4,editText5;
    String number,smsmsg,mailid,mailsub,mailmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_sms_mail);
        editText1= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText7);
        editText4= (EditText) findViewById(R.id.editText8);
        editText5= (EditText) findViewById(R.id.editText9);
    }

    public void sendsms(View view) {
        number=editText1.getText().toString();
        smsmsg=editText2.getText().toString();
        SmsManager smsManager =  SmsManager.getDefault();
        smsManager.sendTextMessage(number,null,smsmsg,null,null); //we need to add permission in manifest file to send sms
        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }

    public void sendmail(View view) {
        mailid=editText3.getText().toString();
        mailsub=editText4.getText().toString();
        mailmsg=editText5.getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ mailid});
        email.putExtra(Intent.EXTRA_SUBJECT, mailsub);
        email.putExtra(Intent.EXTRA_TEXT, mailmsg);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :")); // no permission needed for mail
    }
}
