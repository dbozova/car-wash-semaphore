package com.isn;

import java.util.ArrayList;
import java.util.List;
import com.isn.CarWash;
import com.isn.Car;
import java.util.Date;


public class App 
{
    public static void main( String[] args )
    {

        long startTime = new Date().getTime();

        //dummy data
        Car audi = new Car("Audi Q7", "PB1243FD");
        Car mercedes = new Car("Mercedes-Benz A-class", "A0987DA");
        Car opel = new Car("Opel Astra", "E3900PD");
        Car hyundai = new Car("Hyundai Elantra", "PB1354GD");
        Car kia = new Car("Kia K5", "C8587PP");
        Car toyota = new Car("Toyota Corolla", "T3540AE");
        Car mitsubishi = new Car("Mitsubishi Lancer", "PB3454DS");
        Car cadillac = new Car("Cadillac Eldorado Biarritz", "A0747YH");
        Car ferrari = new Car("Ferrari 312P", "PA5412UH");


        List<Car> Queue = new ArrayList<>();
        Queue.add(audi);
        Queue.add(mercedes);
        Queue.add(opel);
        Queue.add(hyundai);
        Queue.add(kia);
        Queue.add(toyota);
        Queue.add(mitsubishi);
        Queue.add(cadillac);
        Queue.add(ferrari);

        
        for (int i = 0; i < 9; i++) {
            CarWash carWash = new CarWash(Queue.get(i), startTime);
            Thread thread = new Thread(carWash);
            thread.start();
        }
        
    }
        
       
}

