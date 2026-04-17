package org.mp.sesion07.ordenacion;

import java.util.Arrays;

public class Ordenacion {

    // 🔹 Inserción
    public static <T extends Comparable<T>> void ordenacionPorInsercion(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T clave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(clave) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = clave;
        }
    }

    // 🔹 MergeSort
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length < 2) return;
        mergeSortRec(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSortRec(T[] arr, int izq, int der) {
        if (izq >= der) return;

        int mid = (izq + der) / 2;

        mergeSortRec(arr, izq, mid);
        mergeSortRec(arr, mid + 1, der);
        merge(arr, izq, mid, der);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int izq, int mid, int der) {

        int n1 = mid - izq + 1;
        int n2 = der - mid;

        T[] left = Arrays.copyOfRange(arr, izq, mid + 1);
        T[] right = Arrays.copyOfRange(arr, mid + 1, der + 1);

        int i = 0, j = 0, k = izq;

        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    // 🔹 Arrays.sort
    public static <T extends Comparable<T>> void sort(T[] arr) {
        Arrays.sort(arr);
    }
}
