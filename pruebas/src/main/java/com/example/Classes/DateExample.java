package com.example.Classes;

import java.util.Calendar;

public class DateExample {
    
    public void dateExample(){
         // Arreglo de días de la semana
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        // Arreglo de meses del año
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        
        // Obtener la fecha actual
        Calendar calendar = Calendar.getInstance();

        // Formato de la fecha: "Guatemala, 14 de Junio de 2012"
        String fechaActual = "Guatemala, " + calendar.get(Calendar.DAY_OF_MONTH) + " de "
                + meses[calendar.get(Calendar.MONTH)] + " de " + calendar.get(Calendar.YEAR);
        
        System.out.println(fechaActual);

        // Arreglo de letras del abecedario en minúsculas
        char[] abecedario = new char[26];
        int i = 0;

        // Cargar el arreglo de letras utilizando un ciclo while
        while (i < abecedario.length) {
            abecedario[i] = (char) ('a' + i);
            i++;
        }

        // Imprimir el abecedario en forma descendente usando un ciclo for
        for (int j = abecedario.length - 1; j >= 0; j--) {
            System.out.print(abecedario[j] + " ");
        }
    }
}
