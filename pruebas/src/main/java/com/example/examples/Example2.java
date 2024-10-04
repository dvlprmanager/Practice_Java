package com.example.examples;

import com.example.Classes.Punto;

public class Example2 {


    public void ExampleList(){

        Integer[] series = new Integer[3];
        series[0] = 10;
        series[1] = 20;

        Punto[] marcado = {
            new Punto(1,5),
            new Punto(3,3),
            new Punto(2,3)
        };
        
        String[] titulos = {"sr.", "sra.", "srita.", "Dr."};

        String nombres[] = new String[10];

        nombres[10] = "Josue";

        System.out.println("Mi Nombre es: " + nombres[10]);
    }

    

}
