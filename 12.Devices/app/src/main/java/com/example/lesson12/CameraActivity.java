package com.example.lesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.example.lesson12.databinding.ActivityCameraBinding;

public class CameraActivity extends AppCompatActivity {

    private ActivityCameraBinding binding;
    private static final int TAKE_PICTURE = 1;
    private static final int RECORD_VIDEO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCameraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btnTakePicture = findViewById(R.id.btnTakePicture);
        Button btnRecordVideoIntent = findViewById(R.id.btnRecordVideoIntent);
        Button btnRecordVideoMediaRecorder = findViewById(R.id.btnRecordVideoMediaRecorder);

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, TAKE_PICTURE);
            }
        });

        btnRecordVideoIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, RECORD_VIDEO);
            }
        });

        btnRecordVideoMediaRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the MediaRecorder video recording functionality here
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    Uri imageUri = data.getData(); // Uri of the taken picture
                    // Implement handling of the taken picture here
                    binding.imageview.setImageURI(imageUri);
                    break;

                case RECORD_VIDEO:
                    Uri videoUri = data.getData(); // Uri of the recorded video
                    // Implement handling of the recorded video here
                    binding.videoView.setVideoURI(videoUri);
                    break;
            }
        }
    }
}