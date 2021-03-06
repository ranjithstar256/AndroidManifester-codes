package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationInAndroid extends AppCompatActivity {
    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_in_android);

        imageView = findViewById(R.id.imageView2);
        //1. frame animation
        //2. tween
        //2.1 alpha - fade in/out
        //2.2 scale - moving objrcts
        //2.3 rotate - rotate
        //2.4 tranlate - zoom in / out

        animation= AnimationUtils.loadAnimation(AnimationInAndroid.this, R.anim.somename);
    }

    public void rote(View view) {

        imageView.startAnimation(animation);

    }
}
