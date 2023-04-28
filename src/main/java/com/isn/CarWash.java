package com.isn;

import java.util.concurrent.Semaphore;

public class CarWash implements Runnable{

    private long startTime;
    private Time time;

    //number of slots at the car wash
    private static final int CAPACITY = 5;
    //true if occupied,  false if free
    private static final boolean[] CAR_WASH_CAPACITY = new boolean[CAPACITY];

    //guarantees first-in first-out granting of permits under contention
    private static final Semaphore SEMAPHORE = new Semaphore(CAPACITY, true);
 
    private Car car;
 
    public CarWash(Car car, long startTime) {
        this.car = car;
        this.startTime = startTime;
        time = new Time();
    }
 
    @Override
    public void run() {
        System.out.println(
                this.car.toString() + " is waiting at the entrance");
 
        try {
            //acquire() will request access to code below, if denied the thread is blocked until semaphore allows access
            SEMAPHORE.acquire();

            int position = -1;

            //checking if there is a free slot, if yes, a car takes it
            synchronized (CAR_WASH_CAPACITY){
                for (int i = 0; i < CAPACITY; i++) {
                    if (!CAR_WASH_CAPACITY[i]){
                        CAR_WASH_CAPACITY[i] = true;
                        position = i;
                        System.out.println(this.car.toString() 
                                + " is being washed at the " + i + " slot ");
                        break;
                    }
                }
            }
            //washing time
            time.timeManagement(this.car, startTime);

            //release slot
            synchronized (CAR_WASH_CAPACITY){
                CAR_WASH_CAPACITY[position] = false;
            }
            //releasing resource
            SEMAPHORE.release();
            //System.out.println(this.car.toString() + " has finished washing ");
        }catch (InterruptedException e) {

        }
    }
}
 