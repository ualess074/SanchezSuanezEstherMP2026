package org.mp.sesion07.ordenacion;

import java.util.Arrays;

public class OrdenacionApp {

    public static void main(String[] args) {

        Integer[] datos = {5, 2, 9, 1, 3};

        System.out.println("Original: " + Arrays.toString(datos));

        Ordenacion.mergeSort(datos);

        System.out.println("Ordenado: " + Arrays.toString(datos));
    }
}
