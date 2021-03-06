package kp.ranjith.raguclasscodes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetSharedPrefData extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String s1, s2;
    SharedPreferences.Editor editor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_shared_pref_data);

        sharedPreferences=getSharedPreferences("sfname",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        tv = findViewById(R.id.textView6);

    }

    public void getsh(View view) {
        s1=sharedPreferences.getString("key1","def val");
        s2=sharedPreferences.getString("key2","def val");

        tv.setText(s1+"\n"+s2);

    }
}
