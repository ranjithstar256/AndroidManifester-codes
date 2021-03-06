package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GettingDatafromEditText extends AppCompatActivity {

    EditText ed1;
    String s;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_datafrom_edit_text);
        ed1 = findViewById(R.id.editText2);
        tv = findViewById(R.id.textView);
    }

    public void somename(View view) {
        s=ed1.getText().toString();

        tv.setText(s);

    }
}
