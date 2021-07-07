package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivityForResultExample extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result_example);
        imageView = findViewById(R.id.imageView);
    }

    public void opencamm(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 66);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap myBitmap;
        if (data == null) {
            Toast.makeText(this, "nul", Toast.LENGTH_SHORT).show();
        } else {
            myBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(myBitmap);
        }
    }
}

