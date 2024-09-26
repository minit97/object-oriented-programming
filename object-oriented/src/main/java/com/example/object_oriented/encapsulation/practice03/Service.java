package com.example.object_oriented.encapsulation.practice03;

public class Service {

    public void test() {
        Timer t = new Timer();
        t.startTime = System.currentTimeMillis();

        // ...

        t.stopTime = System.currentTimeMillis();

        long elaspedTime = t.stopTime - t.startTime;
    }
}
