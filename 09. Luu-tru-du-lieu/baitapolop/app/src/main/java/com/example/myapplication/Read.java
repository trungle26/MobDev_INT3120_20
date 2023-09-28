package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnv1_table);

        // Assuming "hello.txt" exists in the internal storage

        StringBuilder sb = new StringBuilder();

        try {
            // Open the file input stream
            FileInputStream fis = openFileInput("hello.txt");

            // Create an input stream reader
            InputStreamReader isr = new InputStreamReader(fis);

            // Create a buffered reader
            BufferedReader bufferedReader = new BufferedReader(isr);

            String line;

            // Read lines until end of file
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            // Close the file input stream
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Now sb.toString() contains the content of "hello.txt"
    }
}