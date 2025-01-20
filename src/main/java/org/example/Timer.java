package org.example;

public class Timer {
    private long startTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public int getTimeInS() {
        long currentTime = System.currentTimeMillis();
        return (int) Math.ceil((currentTime - startTime) / 1000.0);
    }


}
