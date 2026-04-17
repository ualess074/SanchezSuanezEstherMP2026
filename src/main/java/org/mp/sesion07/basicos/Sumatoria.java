package org.mp.sesion07.basicos;

public class Sumatoria {

    public static int sumaRec(int n) {
        if (n <= 1) return n;
        return n + sumaRec(n - 1);
    }

    public static int sumaIter(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }

    public static int sumaGaus(int n) {
        return n * (n + 1) / 2;
    }
}
