package com.example.thread20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("BBB",Thread.currentThread().getName());


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    Log.d("BBB","A " + i);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    Log.d("BBB","B " + i);
                }
            }
        });

        threadB.start();
        threadA.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB",threadA.getState().name());
                Log.d("BBB",threadB.getState().name());
            }
        },2000);

    }
}