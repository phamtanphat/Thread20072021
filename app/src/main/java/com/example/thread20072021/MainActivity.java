package com.example.thread20072021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Thread threadA, threadB , threadC;
    int a , b , c;
    MyFlag myFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("BBB",Thread.currentThread().getName());
        a = b = c = 0;

        myFlag = new MyFlag(1);


        threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1 ; i <= 50 ; i++){
                        if (myFlag.index == 1){
                            a = i;
                            Log.d("BBB", "A : " + a);
                            myFlag.index = 2;
                            myFlag.notifyAll();
                        }else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1 ; i <= 50 ; i++){
                        if (myFlag.index == 2){
                            b = i;
                            Log.d("BBB", "B : " + b);
                            myFlag.index = 3;
                            myFlag.notifyAll();
                        }else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });

        threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 1 ; i <= 50 ; i++){
                        if (myFlag.index == 3){
                            c = a + b;
                            Log.d("BBB", "C : " + c);
                            myFlag.index = 1;
                            myFlag.notifyAll();
                        }else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        threadB.start();
        threadA.start();
        threadC.start();

    }


}