package kp.ranjith.raguclasscodes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NotificationExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);

    }

    public void shownofn(View view) {

        // 1. create a Intent
        // 2. create a PendingIntent
        // 3. design Notification
        // 4. initilaze NotifivstionManager


        Intent  intent = new Intent(NotificationExample.this,MainActivity.class);

        PendingIntent  pendingIntent = PendingIntent.getActivity(NotificationExample.this,0,intent,0);

        Notification notification = new Notification.Builder(NotificationExample.this).setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("New message received")
                .setContentIntent(pendingIntent)
                .setContentText("message from harsha")
                .build();

        NotificationManager  notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0,notification);

    }
}