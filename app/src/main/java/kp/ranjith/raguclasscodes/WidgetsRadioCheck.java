package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class WidgetsRadioCheck extends AppCompatActivity {
    Button b1;
    RadioGroup radioGroup;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_radio_check);
        b1 = (Button) findViewById(R.id.button4);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        cb = (CheckBox) findViewById(R.id.checkBox);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id;

                id = radioGroup.getCheckedRadioButtonId();

                switch (id) {
                //add the different coding for diffrent cases
                    case R.id.button:

                        break;
                    case R.id.button2:
                        Toast.makeText(WidgetsRadioCheck.this, "changes", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button3:
                        Toast.makeText(WidgetsRadioCheck.this, "Example", Toast.LENGTH_SHORT).show();
                        break;

                }

                if (cb.isChecked()) {
                    Toast.makeText(WidgetsRadioCheck.this, "checkbox checked", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(WidgetsRadioCheck.this, "checkbox not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}