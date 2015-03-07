package com.ex.alvaro.pruebaservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Alvaro on 06/03/2015.
 */
public class servicioClass extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int a=0;
        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        Toast.makeText(this,"Servicio Iniciado "+mydate+" ??",Toast.LENGTH_LONG).show();
        crearNotificaciones();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Servicio Destruido", Toast.LENGTH_LONG).show();
    }

    private void crearNotificaciones() {

        Notification.Builder notificacion=new Notification.Builder(servicioClass.this);
        notificacion.setSmallIcon(R.drawable.ic_launcher);
        notificacion.setTicker("Llamada Perdida");
        notificacion.setWhen(System.currentTimeMillis());
        notificacion.setContentTitle("Pare Kentenich");
        notificacion.setContentText("Desea devolver la llamada?");
        notificacion.setContentInfo("Desde el Snatuario");


        //Sonido
            Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
            notificacion.setSound(sonido);

        //Accion de la notificacion
        PendingIntent pending;
        Intent intent=new Intent();
        Context con=getApplicationContext(); // tambien podria llamarse en el intent, con ProgarmarActivity.getContext, o con getAplicationContext
        intent.setClass(con, MainActivity.class);
        intent.putExtra("ID",1);
        pending=PendingIntent.getActivity(con,0,intent,0);
        notificacion.setContentIntent(pending);

        Notification n=notificacion.getNotification(); // Esta opcion sirve para construit por el motodo antiguo, para api anterio a 16. Se puede cambiar por .build()
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,n);
    }
}
