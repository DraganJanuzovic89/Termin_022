package com.ftninformatika.termin_022;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class MyService extends Service {

    public static final String MSG_TAG = "msg_tag";
    public static final int NOTIF_ID = 1;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String msg = intent.getStringExtra(MSG_TAG);

        showServiceNotification(msg);

        return Service.START_NOT_STICKY;
    }

    private void showServiceNotification(String msg){

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                0);
        Notification notification = new NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
                .setContentTitle("Our Foreground Service")
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_baseline_local_pizza_24)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(NOTIF_ID, notification);
    }
}
