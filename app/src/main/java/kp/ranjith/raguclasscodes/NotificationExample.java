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
showNotification(this, "", "", intent) ;
    }

public void showNotification(Context context, String title, String body, Intent intent) {
    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    int notificationId = 1;
    String channelId = "channel-01";
    String channelName = "Channel Name";
    int importance = NotificationManager.IMPORTANCE_HIGH;

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        NotificationChannel mChannel = new NotificationChannel(
                channelId, channelName, importance);
        notificationManager.createNotificationChannel(mChannel);
    }

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body);

    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
    stackBuilder.addNextIntent(intent);
    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT
    );
    mBuilder.setContentIntent(resultPendingIntent);

    notificationManager.notify(notificationId, mBuilder.build());
}

    public void shownofn(View view) {

        // 1. create a Intent
        // 2. create a PendingIntent
        // 3. design Notification
        // 4. initilaze NotifivstionManager


        Intent  intent = new Intent(NotificationExample.this,NotificationExample.class);

        PendingIntent  pendingIntent = PendingIntent.getActivity(NotificationExample.this,0,intent,0);

        Notification notification = new Notification.Builder(NotificationExample.this).setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("New message received")
                .setContentIntent(pendingIntent)
                .setContentText("message from Ragu")
                .build();

        NotificationManager  notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0,notification);

    }
    public void showNotification() {
        NotificationManager notificationManager = (NotificationManager) MainActivity2.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;        String channelId = "channel-01";        String channelName = "Channel Name";        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity2.this, channelId)
                .setSmallIcon(android.R.drawable.ic_media_play).setContentTitle("ITM Reopened").setContentText("Start coming to college!!");

        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity2.this, 0, intent, 0);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
}
