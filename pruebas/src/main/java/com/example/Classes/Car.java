package com.example.Classes;

import com.example.Interfaces.Electric;
import com.example.Interfaces.Vehicle;

public class Car implements Vehicle, Electric {

    private int speed;
    private int batteryLevel;

    @Override
    public void chargeBattery() {
        System.out.println("Charging the battery...");
        batteryLevel = 100; // Full recharge
        System.out.println("Battery fully charged.");
    }

    @Override
    public int getBatteryLevel() {
        // TODO Auto-generated method stub
       return batteryLevel;
    }

    @Override
    public void start() {
        if (batteryLevel > 0) {
            System.out.println("The car has started.");
            speed = 20; // Initial speed when starting
        } else {
            System.out.println("Not enough battery to start.");
        }
    }

    @Override
    public void stop() {
        System.out.println("The car has stopped.");
        speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

     // Additional method that simulates battery consumption while the car is running
     public void drive() {
        if (speed > 0) {
            System.out.println("The car is moving.");
            batteryLevel -= 10; // Consuming battery
            if (batteryLevel <= 0) {
                batteryLevel = 0;
                System.out.println("The battery has run out. The car stops.");
                stop();
            }
        } else {
            System.out.println("The car is stopped.");
        }
    }

}
