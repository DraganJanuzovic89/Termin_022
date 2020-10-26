package com.ftninformatika.termin_022;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApp extends Application {

    public static final String CHANNEL_ID = "my_channel_id";


    @Override
    public void onCreate() {
        super.onCreate();

    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My NotifChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Description");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}
