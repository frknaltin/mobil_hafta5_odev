package com.example.mobil_hafta5_odev;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textViewCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        relativeLayout = findViewById(R.id.relativeLayout);
        textViewCenter = findViewById(R.id.textViewCenter);

        Bundle extras = getIntent().getExtras();
        int randomNumber = extras.getInt("randomNumber");

        final Handler handlerTextView = new Handler();
        final Random random = new Random();
        handlerTextView.postDelayed(new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                counter++;
                textViewCenter.setText(String.valueOf(counter));

                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                relativeLayout.setBackgroundColor(color);

                if (counter < randomNumber) {
                    handlerTextView.postDelayed(this, 2000); // Her 2 saniyede güncelleme
                }
            }
        }, 2000);
    }
}

