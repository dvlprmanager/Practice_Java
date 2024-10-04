package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Classes.Car;
import com.example.examples.Example1;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Example1 pr = new Example1();


        // Inicio Ejemplo 1

        List<Integer> dataList = new ArrayList<>();
        int resp = 0;

        System.out.print("Ingresa los datos ");

        do {
            System.out.print("Ingresa los datos ");
            int data = scanner.nextInt();
            dataList.add(data);

            System.out.print("Desea seguir Ingresando datos 1. Si , 2. No  ");
            resp = scanner.nextInt();

        } while (resp == 1);

        System.out.print("Calculando el numero Mayor ");

        
        int num = pr.numeroMayour(dataList);

        System.out.print("El numero Mayor es: --> " + num);

        // fin Ejemplo 1

        // inicio ejemplo 2

        System.out.print("Calculadora dimanica  ");

        System.out.print("Ingresa El primer dato ");
        double dat1 = scanner.nextDouble();

        System.out.print("Ingresa El primer dato ");
        double dat2 = scanner.nextDouble();

        System.out.print("Ingresa El Operador valido (por ejemplo: +, -, *, /): ");
        char operator  = scanner.next().charAt(0);

        String resString = pr.dynamicOperator(dat1, dat2, operator);

        System.out.print(resString);

        // fin ejemplo 2

        // inicio ejemplo interfaces 

        Car myCar = new Car();

       // Use methods from the Vehicle interface
       myCar.start();
       System.out.println("Current speed: " + myCar.getSpeed() + " km/h");

       // Drive the car
       myCar.drive();
       System.out.println("Battery level: " + myCar.getBatteryLevel() + "%");

       // Stop the car
       myCar.stop();
       System.out.println("Current speed: " + myCar.getSpeed() + " km/h");

       // Use methods from the Electric interface
       myCar.chargeBattery();
       System.out.println("Battery level after charging: " + myCar.getBatteryLevel() + "%");



    }
}