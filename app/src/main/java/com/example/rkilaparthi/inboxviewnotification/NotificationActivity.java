package com.example.rkilaparthi.inboxviewnotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

/**
 * Created by rkilaparthi on 9/26/2016.
 */
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(1);
    }
}
