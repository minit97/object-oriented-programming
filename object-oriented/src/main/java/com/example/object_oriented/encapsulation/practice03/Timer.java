package com.example.object_oriented.encapsulation.practice03;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long stopTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public long elapsedTime(TimeUnit unit) {
        return switch (unit) {
            case MILLISECONDS -> stopTime - startTime;
            default -> 0;
        };
    }


}
