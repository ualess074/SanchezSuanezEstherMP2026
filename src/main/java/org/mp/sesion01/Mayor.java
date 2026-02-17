package org.mp.sesion01;

public class Mayor {

    public static int elEnteroMayor(int[] a) {

        // Se corrige el valor inicial de max para que sea el primer elemento del array
        int max = a[0];

        // Se corrige el bucle para recorrer todos los elementos del array
        for (int indice = 1; indice < a.length; indice++) {
            if (a[indice] > max) {
                max = a[indice];
            }
        }

        return max;
    }
}

