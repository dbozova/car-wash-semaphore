package com.isn;

public class Car {
    private String model;
    private String plate;

    public Car(String model, String number ){
        this.model = model;
        this.plate = number;    
    }

    public String toString() {
        return "Car model : " + model + " with plate registration: " + plate;
    }
}

