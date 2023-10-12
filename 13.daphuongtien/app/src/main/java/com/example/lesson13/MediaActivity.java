package com.example.lesson13;


import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MediaActivity extends AppCompatActivity {
    Button prev, play, next;
    MediaPlayer player = new MediaPlayer();
    String url =
            "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        play = findViewById(R.id.play);

        player.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
        );
        try {
            player.setDataSource(url);
            player.prepare();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred", e);
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()) {
                    player.pause();
                    play.setBackgroundResource(R.drawable.baseline_play_arrow_24);
                } else {
                    player.start();
                    play.setBackgroundResource(R.drawable.baseline_pause_24);
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (player.isPlaying()) {
            play.setBackgroundResource(R.drawable.baseline_pause_24);
        } else {
            play.setBackgroundResource(R.drawable.baseline_play_arrow_24);
        }
    }
}