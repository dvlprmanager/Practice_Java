package com.example.examples;

import java.util.List;

public class Example1 {
    
    public int numeroMayour(List<Integer> datos){
        int datMayor = 0;

        for (int i : datos) {
            if(datMayor < i){
                datMayor = i;
            }
        }
        return datMayor;
    }

    public String dynamicOperator(double dat1 , double dat2 , char operator  ){
        double result = 0;
     // Aplicar el operador correspondiente
     switch (operator) {
        case '+':
            result = dat1 + dat2;
            break;
        case '-':
            result = dat1 - dat2;
            break;
        case '*':
            result = dat1 * dat2;
            break;
        case '/':
            if (dat2 != 0) {
                result = dat1 / dat2;
            } else {
                return "Error: División por cero";
            }
            break;
        default:
            return "Error: Operador inválido";
    }

    return "El resultado es: " + result;

    }



}
