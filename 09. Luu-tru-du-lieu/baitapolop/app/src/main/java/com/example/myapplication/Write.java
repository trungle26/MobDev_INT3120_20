package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btvn1_constraint);

        // The content you want to write to the file
        String content = "Hello, World!\nThis is a new line.";

        try {
            // Open the file output stream
            FileOutputStream fos = openFileOutput("hello.txt", Context.MODE_PRIVATE);

            // Write the content as bytes
            fos.write(content.getBytes());

            // Close the file output stream
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}