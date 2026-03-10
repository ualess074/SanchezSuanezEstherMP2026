package org.mp.sesion03.mezclalineal;

public class MezclaLineal {

    public static int[] mezclaLinealInt(int[] arr1, int[] arr2) {

        int[] resultado = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                resultado[k++] = arr1[i++];
            } else {
                resultado[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            resultado[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            resultado[k++] = arr2[j++];
        }

        return resultado;
    }

    public static <T extends Comparable<T>> T[] mezclaLinealComparables(T[] arr1, T[] arr2) {

        T[] resultado = java.util.Arrays.copyOf(arr1, arr1.length + arr2.length);

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i].compareTo(arr2[j]) <= 0) {
                resultado[k++] = arr1[i++];
            } else {
                resultado[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            resultado[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            resultado[k++] = arr2[j++];
        }

        return resultado;
    }
}