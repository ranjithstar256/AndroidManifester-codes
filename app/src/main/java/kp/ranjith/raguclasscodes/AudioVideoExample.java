package kp.ranjith.raguclasscodes;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class AudioVideoExample extends AppCompatActivity {
    VideoView videoView;
    public static String MY_VIDEO = "http://www.ebookfrenzy.com/android_book/movie.mp4";
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video_example);

        mediaPlayer = MediaPlayer.create(AudioVideoExample.this, R.raw.abc); /// audio file name small letter
        videoView = (VideoView) findViewById(R.id.videoView);
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
                    try {
                // Start the MediaController

                MediaController mediacontroller = new MediaController(AudioVideoExample.this);
                mediacontroller.setAnchorView(videoView);
                // Get the URL from String VideoURL
                Uri video = Uri.parse(MY_VIDEO);
                videoView.setMediaController(mediacontroller);
                videoView.setVideoURI(video);
                videoView.start();

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
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