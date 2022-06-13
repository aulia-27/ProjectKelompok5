package com.example.projectmobileapplaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projectmobileapplaundry.Login.LoginActivity;
import com.example.projectmobileapplaundry.MainActivity.MainActivity;

public class SplashScreenLaundry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_laundry);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreenLaundry.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}