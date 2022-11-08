package kp.ranjith.s3_v2_viewmodeldemo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import kp.ranjith.raguclasscodes.R;
/*
This code example is from Smartherd , credits to them.
*/
public class MainActivity2 extends AppCompatActivity {
    TextView tv;

    MutableLiveData<String> mutstr;
    EditText eed;

    MutableLiveData<Something> sthob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv = findViewById(R.id.textView);
        eed = findViewById(R.id.editTextTextPersonName);




        sthob =new MutableLiveData<>();

        Something v = new Something();
        v.setName("Ranjith");
        v.setLocation("india");

        sthob.setValue(v);

        sthob.observe(this, new Observer<Something>() {
            @Override
            public void onChanged(@Nullable Something something) {
                something.getName();
                something.getLocation();
            }
        });



        mutstr =new MutableLiveData<>();
        mutstr.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv.setText(s);
            }
        });
        eed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mutstr.setValue(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void chang(View view) {
        String s = "Good Evening";
        mutstr.setValue(s);
    }

    public void hng(View view) {
        mutstr.setValue(eed.getText().toString());
    }
}