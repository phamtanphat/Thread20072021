package com.example.thread20072021;

import android.util.Log;

public class Work {
    int count;

    public Work(int count) {
        this.count = count;
    }

    public void handle(String name) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            count = i;
            Log.d("BBB",name + " " + count);
        }
    }
}
