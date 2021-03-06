package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceExample extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    EditText ed1, ed2;

    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_example);

        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);


    }

    public void save1(View view) {
        s1=ed1.getText().toString();
        s2=ed2.getText().toString();

        editor.putString("key1",s1);
        editor.putString("key2",s2);


        editor.commit();

        startActivity(new Intent(SharedPreferenceExample.this,GetSharedPrefData.class));

        // once a data stored in shared preference , we can get from any activity!
        //lets get it from GetSharedPrefData  class
    }
}
