package com.example.thread20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Thread threadA, threadB;
    Work work;

    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("BBB",Thread.currentThread().getName());

        Thread1 T1 = new Thread1();
        Thread2 T2 = new Thread2();
        T1.start();
        T2.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","Thread 1 " + T1.getState().name() + " " + T1.isAlive() );
                Log.d("BBB","Thread 2 " + T2.getState().name() + " " + T2.isAlive());

            }
        },2000);
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                Log.d("BBB","Cop: Holding criminal's friend...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
                Log.d("BBB","Cop: Waiting for criminal release hostage...");

                synchronized (Lock2) {
                    Log.d("BBB","Cop 1: Holding criminal's friend &amp;amp;amp;amp;amp;amp;amp;amp; hostage...");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (Lock2) {
                Log.d("BBB","Criminal: Holding hostage...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                Log.d("BBB","Criminal: Waiting for cop release friend...");
                synchronized (Lock1) {
                    Log.d("BBB","Criminal: Holding friend &amp;amp;amp;amp;amp;amp;amp;amp; hostage...");
                }
            }
        }
    }

}