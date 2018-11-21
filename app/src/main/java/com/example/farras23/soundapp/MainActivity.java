package com.example.farras23.soundapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private static final String isPlaying = "Media is Playing";
    MediaPlayer player;
    Button btn1, btn2, btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.ambulan);
        btn2 = (Button) findViewById(R.id.mobil);
        btn3 = (Button) findViewById(R.id.kapal);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                playSound(1);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                playSound(2);
            }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                playSound(3);
            }
        });
    }

    public void onPause() {
        try {
            super.onPause();
            player.pause();
        } catch (Exception e) {
        }
    }

    private void playSound(int arg) {
        try {
            if (player.isPlaying());{
                player.stop();
                player.release();

            }
        }catch (Exception e){
            Toast.makeText(this, "Masuk Exception", Toast.LENGTH_LONG).show();
        }
        if (arg == 1){
            Toast.makeText(this, isPlaying+"Ambulan", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.ambulan);
        }
        if (arg == 2){
            Toast.makeText(this, isPlaying+"mobil", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.mobil);
        }
        if (arg == 3){
            Toast.makeText(this, isPlaying+"Kapal", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.kapal);
        }
        player.setLooping(false);
        player.start();
    }
}
