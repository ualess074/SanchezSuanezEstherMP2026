package org.mp.sesion01;

/**
 * Clase que proporciona métodos para trabajar con arrays de enteros.
 */
public class Mayor {

    public static int elEnteroMayor(int[] a) {

        if (a == null) {
            throw new IllegalArgumentException("Array nulo");
        }

        if (a.length == 0) {
            throw new RuntimeException("Array vacio");
        }

        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }
}

