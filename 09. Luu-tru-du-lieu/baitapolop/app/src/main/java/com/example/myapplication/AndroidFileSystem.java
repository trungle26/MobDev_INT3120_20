package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AndroidFileSystem extends AppCompatActivity {

    // Define a constant for the preferences file name
    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap_ve_nha1);
        // Assuming mSilentMode is a boolean variable you want to store
        boolean mSilentMode = true;

        // Get SharedPreferences object
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Create an editor to make preference changes
        SharedPreferences.Editor editor = settings.edit();

        // Put the boolean value in the editor
        editor.putBoolean("silentMode", mSilentMode);

        // Commit the changes
        editor.apply(); // Use apply() for asynchronous saving
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bai1_option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.miBtvn1Constraint:
                Intent intent = new Intent(this, Write.class);
                startActivity(intent);
                break;
            case R.id.miBtvn1Linear:
                Intent intent2 = new Intent(this,btvn1Linear.class);
                startActivity(intent2);
                break;
            case R.id.miBtvn1Relative:
                Intent intent3 = new Intent(this,btvn1Relative.class);
                startActivity(intent3);
                break;
            case R.id.miBtvn1Table:
                Intent intent4 = new Intent(this, Read.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
}