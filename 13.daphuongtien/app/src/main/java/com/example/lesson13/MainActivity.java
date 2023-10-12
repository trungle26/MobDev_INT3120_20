package com.example.lesson13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnMedia(View view) {
        intent = new Intent(MainActivity.this, MediaActivity.class);
        startActivity(intent);
    }

    public void btnLocation(View view) {
        intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivity(intent);
    }

    public void btnMap(View view) {
        intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

}