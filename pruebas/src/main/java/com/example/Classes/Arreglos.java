package com.example.Classes;

public class Arreglos {
    public void ejemploArreglos() {
        // Arreglo unidimensional
        int[] guatemala = {2500000, 2900000, 3500000};
        int[] elSalvador = new int[guatemala.length];
        int[] total = new int[guatemala.length];
        int promedio;

        elSalvador[0] = 2500000;
        elSalvador[1] = 2900000;
        elSalvador[2] = 3800000;

        for (int i = 0; i < guatemala.length; i++) {
            total[i] = guatemala[i] + elSalvador[i];
            System.out.println((i + 2007) + " producción: " + total[i]);
        }

        int sum = 0;
        for (int value : total) {
            sum += value;
        }
        promedio = sum / total.length;
        System.out.println("Producción promedio: " + promedio);
    }
}
