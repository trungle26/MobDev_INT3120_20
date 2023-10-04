package com.example.a11services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class HelloIntentService extends IntentService {

    public HelloIntentService() {
        super("HelloIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Normally we would do some work here, like download a file
        try{
            Thread.sleep(5000);
            Log.d("intent service","intent service finished");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}