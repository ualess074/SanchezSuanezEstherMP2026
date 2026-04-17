package org.mp.sesion07.basicos;

public class Factorial {

    public static long factorialRec(int n) {
        if (n <= 1) return 1;
        return n * factorialRec(n - 1);
    }

    public static long factorialIter(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
