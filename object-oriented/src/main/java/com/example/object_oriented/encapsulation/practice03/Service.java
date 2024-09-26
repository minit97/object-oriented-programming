package com.example.object_oriented.encapsulation.practice03;

import java.util.concurrent.TimeUnit;

public class Service {

    public void test() {
        Timer t = new Timer();
        t.start();

        // ...

        t.stop();

        long elaspedTime = t.elapsedTime(TimeUnit.MILLISECONDS);
    }
}
