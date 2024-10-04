package com.example.Classes;

public class Ciclos {
    public void ejemploCicloFor() {
        int[] guatemala = {2500000, 2900000, 3500000};
        int[] elSalvador = {2500000, 2900000, 3800000};
        int[] total = new int[guatemala.length];
        int sum = 0;

        for (int i = 0; i < guatemala.length; i++) {
            total[i] = guatemala[i] + elSalvador[i];
            System.out.println((i + 2007) + " producción: " + total[i]);
            sum += total[i];
        }
        System.out.println("Producción promedio: " + sum / total.length);
    }

    public void ejemploCicloWhile() {
        int[] guatemala = {2500000, 2900000, 3500000};
        int[] elSalvador = {2500000, 2900000, 3800000};
        int[] total = new int[guatemala.length];
        int sum = 0;
        int i = 0;

        while (i < guatemala.length) {
            total[i] = guatemala[i] + elSalvador[i];
            System.out.println((i + 2007) + " producción: " + total[i]);
            sum += total[i];
            i++;
        }
        System.out.println("Producción promedio: " + sum / total.length);
    }
}
