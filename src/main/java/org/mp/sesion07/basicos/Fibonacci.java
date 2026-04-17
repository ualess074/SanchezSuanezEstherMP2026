package org.mp.sesion07.basicos;

public class Fibonacci {

    public static long fibonacciRec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static long fibonacciIter(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
