package kp.ranjith.s3_v2_viewmodeldemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import kp.ranjith.raguclasscodes.R;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        final TextView mTextView = findViewById(R.id.tvNumber);
        Button mButton = findViewById(R.id.bRandom);

        final MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final LiveData<String> myRandomNumber = model.getNumber();

        // Observe the LiveData
        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // Update the UI
                mTextView.setText(s);
                Log.i(TAG, "Data Updated in UI");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });

        Log.i(TAG, "Random Number Set");
    }
}
