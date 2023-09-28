package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class External extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap_ve_nha2);


        StorageUtils storageUtils = new StorageUtils();

        if (storageUtils.isExternalStorageWritable()) {
            // External storage is available for read and write
            // You can perform write operations here
        } else if (storageUtils.isExternalStorageReadable()) {
            // External storage is available for at least reading
            // You can perform read-only operations here
        } else {
            // External storage is not available
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bai2_option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.miBtvn1Constraint:
                Intent intent = new Intent(this, ReadDatabase.class);
                startActivity(intent);
                break;
            case R.id.miBtvn1Linear:
                Intent intent2 = new Intent(this, writeDatabase.class);
                startActivity(intent2);
                break;
            case R.id.miBtvn1Relative:
                Intent intent3 = new Intent(this,btnv2Relative.class);
                startActivity(intent3);
                break;
            case R.id.miBtvn1Table:
                Intent intent4 = new Intent(this, deleteDatabase.class);
                startActivity(intent4);
                break;
        }
        return true;
    }

    void deleteExternalStoragePrivateFile() {
        // Get path for the file on external storage.  If external
        // storage is not currently mounted this will fail.
        File file = new File(getExternalFilesDir(null), "DemoFile.jpg");
        if (file != null) {
            file.delete();
        }
    }

}