package com.example.puzzelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.puzzelproject.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
     ActivityHomeBinding  binding;
    MediaPlayer mediaPlayer;
    boolean isplaying = false;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
      setContentView(binding.getRoot());

//        if (!isplaying ) {
//            intent = new Intent(getBaseContext(), MyService.class);
//            startForegroundService(intent);
//            isplaying = true;
//        }else {
//            stopService(intent);
//
//            isplaying = false;
//
//        }
         intent = new Intent(getBaseContext(),MyService.class);
        startService(intent);


        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Setting.class));

            }
        });
        binding.btnStartplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),Profile.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent = new Intent(getBaseContext(),MyService.class);
        stopService(intent);
    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        intent = new Intent(getBaseContext(),MyService.class);
//        stopService(intent);
//    }
}