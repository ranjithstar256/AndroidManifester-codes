package kp.ranjith.raguclasscodes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);
    }

    public void shownvofn(View view) {
//this code is for before Oreo
        // 1. create a Intent
        // 2. create a PendingIntent
        // 3. design Notification
        // 4. initilaze NotifivstionManager


        Intent intent = new Intent(NotificationExample.this, NotificationExample.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationExample.this, 0, intent, PendingIntent.FLAG_MUTABLE);

        Notification notification = new Notification.Builder(NotificationExample.this).setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("New message received")
                .setContentIntent(pendingIntent)
                .setContentText("message from Ragu")
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, notification);

    }

    public void shownofn(View view) {
        NotificationManager notificationManager = (NotificationManager) NotificationExample.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationExample.this, channelId)
                .setLargeIcon(BitmapFactory.decodeResource(NotificationExample.this.getResources(), R.drawable.logo))
                .setSmallIcon(R.drawable.logo).setContentTitle("You can also 'Learn Android'")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture( BitmapFactory.decodeResource(NotificationExample.this.getResources(),R.drawable.logo)))
                .setContentText("Contact AndroidManifester today!!");

        Intent intent = new Intent(NotificationExample.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationExample.this, 0, intent, PendingIntent.FLAG_MUTABLE);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}
