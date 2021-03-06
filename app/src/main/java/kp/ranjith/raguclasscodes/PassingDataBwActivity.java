package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PassingDataBwActivity extends AppCompatActivity {
    EditText ed1, ed2;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data_bw);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText3);

    }

    public void methodnam(View view) {
        s1=ed1.getText().toString();
        s2=ed2.getText().toString();

        Intent intent = new Intent(PassingDataBwActivity.this,DestinationActivity.class);

        // intent.putExtra( "anytext" ,value needs to be passed);
        intent.putExtra("anytext",s1);
        intent.putExtra("anothertext",s2);

        startActivity(intent);

    }
}
