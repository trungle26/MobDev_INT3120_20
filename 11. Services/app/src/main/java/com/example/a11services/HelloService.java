package com.example.a11services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class HelloService extends Service {
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper){super(looper);}

        @Override
        public void handleMessage(@NonNull Message msg) {
            // Normally we would do some work here like download a file
            Thread.currentThread().interrupt();
            //Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
//            stopSelf(msg.arg1);
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"service starting", Toast.LENGTH_SHORT).show();
        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        Notification notification = new NotificationCompat.Builder(this,"running_channel")
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Service is running")
                .build();
        startForeground(1,notification);
        // If we get killed, after running from here , restart
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's main thread
        // which we don't want to block. We also make it background priority
        // so CPU-intensive work will not disrupt our UI
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Thread.NORM_PRIORITY);
        thread.start();
        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"service done",Toast.LENGTH_SHORT).show();
    }
}
