package com.example.rkilaparthi.inboxviewnotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void createNotification(){
        Intent i=new Intent(MainActivity.this,NotificationActivity.class);
        TaskStackBuilder taskstackbuilder=TaskStackBuilder.create(this);
        taskstackbuilder.addParentStack(NotificationActivity.class);
        taskstackbuilder.addNextIntent(i);
        PendingIntent pendingIntent=taskstackbuilder.getPendingIntent(123,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Android Example");
        builder.setContentText("Hai Ramu");
        builder.setSmallIcon(R.drawable.abc);
        builder.setContentIntent(pendingIntent);
        Notification notification=builder.build();
        builder.setDefaults(notification.DEFAULT_SOUND);
        builder.setVibrate(new long[]{100,2000,500,2000});
        builder.setLights(Color.GREEN,400,400);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, notification);
    }

}