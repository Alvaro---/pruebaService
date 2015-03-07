package com.ex.alvaro.pruebaservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Alvaro on 06/03/2015.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();

        Intent i = new Intent(context, servicioClass.class);
        context.startService(i);

    }

}
