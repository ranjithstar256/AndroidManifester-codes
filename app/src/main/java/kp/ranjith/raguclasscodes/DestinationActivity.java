package kp.ranjith.raguclasscodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DestinationActivity extends AppCompatActivity {

    TextView t1,t2;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        t1= (TextView) findViewById(R.id.textView2);
        t2= (TextView) findViewById(R.id.textView3);

        s1=getIntent().getStringExtra("anytext");
        s2=getIntent().getStringExtra("anothertext");

        t1.setText(s1);
        t2.setText(s2);

    }
}
