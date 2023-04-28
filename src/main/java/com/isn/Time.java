package com.isn;

import java.util.Random;
import java.util.Date;

//Manages washing time
public class Time {
    private static final Random RANDOM = new Random();
    //max time for washing a single car
    private static final int SCOPE = 600;

    public void timeManagement(Car car, long startTime) {
        Integer executionTime = RANDOM.nextInt(SCOPE);

        //testing code for errors while it's being executed
        try {
            Thread.sleep(executionTime.longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long overallTime = new Date().getTime() - startTime;
        System.out.println( car.toString() + " finished washing in " + executionTime + "ms.\nTotal time from start:" + overallTime);
    }
}
