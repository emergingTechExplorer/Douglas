package com.example.alohamusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    MediaPlayer mpUkulele;
    MediaPlayer mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button1 = (Button) findViewById(R.id.btUkulele);
        button2 = (Button) findViewById(R.id.btDrums);

        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);
        playing = 0;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpUkulele.start();
                        playing = 1;
                        button1.setText("Pause Ukulele Song");
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpUkulele.pause();
                        playing = 0;
                        button1.setText("Play Ukulele Song");
                        button2.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpDrums.start();
                        playing = 1;
                        button2.setText("Pause Drums Song");
                        button1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpDrums.pause();
                        playing = 0;
                        button2.setText("Play Drums Song");
                        button1.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

    }
}