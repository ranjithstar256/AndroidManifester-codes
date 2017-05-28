package kp.ranjith.raguclasscodes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartActivityForResultExample extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result_example);
        imageView= (ImageView) findViewById(R.id.imageView);

    }

    public void opencamm(View view) {
        Intent  intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,66);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==66){

            Bitmap bitmap;

            bitmap= (Bitmap)data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);

        }

    }
}
