package kp.ranjith.raguclasscodes;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
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

        mediaPlayer = MediaPlayer.create(AudioVideoExample.this, R.raw.vanthematharam); /// audio file name small letter
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
                    Toast.makeText(AudioVideoExample.this, "Video starting.. please wait..", Toast.LENGTH_SHORT).show();
                    VideoView videoview = (VideoView) findViewById(R.id.videoView);
                    //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);


                    videoview.setVideoPath("https://p.urbanpro.com/tv-prod/video%2Fmember-video%2F2019456%2Fprocessed-video%2F25577-IIT+Hyderabad.mp4");
                    videoview.setMediaController(new MediaController(AudioVideoExample.this));
                    videoview.start();

                }
        else {
            Toast.makeText(this, "Internet unavailable", Toast.LENGTH_SHORT).show();
        }
    }

   public boolean checkinternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}