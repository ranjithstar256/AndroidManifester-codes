package kp.ranjith.raguclasscodes;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class AudioVideoExample extends AppCompatActivity {
    VideoView videoView;
    String MY_VIDEO = "https://www.ebookfrenzy.com/android_book/movie.mp4";
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video_example);

        mediaPlayer = MediaPlayer.create(AudioVideoExample.this, R.raw.abc); /// audio file name small letter
        videoView = findViewById(R.id.videoView);
    }


    public void startt(View view) {

        mediaPlayer.start();
    }

    public void pausee(View view) {
        mediaPlayer.pause();
    }

    public void stopp(View view) {
        mediaPlayer.stop();
    }

    public void startvid(View view) {

        boolean internet = checkinternet(); // this is the coding for checking internet connection

                if (internet) {


                }
        else {
            Toast.makeText(this, "Turn On Internet", Toast.LENGTH_SHORT).show();
        }
    }

   public boolean checkinternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}