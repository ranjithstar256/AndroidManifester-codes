package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WidgetsRadioCheck extends AppCompatActivity {
    Button b1;
    RadioGroup radioGroup;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_radio_check);
        b1 = findViewById(R.id.button4);
        radioGroup = findViewById(R.id.rg);
        cb = findViewById(R.id.checkBox);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id) {
                    //add the different coding for diffrent cases
                    case R.id.button:
                        Toast.makeText(WidgetsRadioCheck.this, "Male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        Toast.makeText(WidgetsRadioCheck.this, "Female", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button3:
                        Toast.makeText(WidgetsRadioCheck.this, "Transgender", Toast.LENGTH_SHORT).show();
                        break;
                }

                if (cb.isChecked()) {
                    Toast.makeText(WidgetsRadioCheck.this, "Terms Agreed", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(WidgetsRadioCheck.this, "Terms not Agreed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}