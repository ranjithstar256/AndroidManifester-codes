package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GettingDatafromEditText extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    String s;
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_datafrom_edit_text);
        ed1 = findViewById(R.id.editText2);
        ed2 = findViewById(R.id.editTextTextPersonName);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView8);

        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    tv2.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void somename(View view) {
        s=ed1.getText().toString();

        tv.setText(s);

    }
}
