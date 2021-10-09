package com.example.thread20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Thread threadA, threadB , threadC;
    int a , b , c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("BBB",Thread.currentThread().getName());
        a = b = c = 0;

        threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 50 ; i++){
                    a = i;
                    Log.d("BBB", "A : " + a);
                }
            }
        });
        threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 50 ; i++){
                    b = i;
                    Log.d("BBB", "B : " + b);
                }
            }
        });

        threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 50 ; i++){
                    c = a + b;
                    Log.d("BBB", "C : " + c);
                }
            }
        });

        threadB.start();
        threadA.start();
        threadC.start();

    }


}