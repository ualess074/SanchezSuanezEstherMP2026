package org.mp.sesion01;

/**
 * Clase que proporciona métodos para trabajar con arrays de enteros.
 * <p>
 * Incluye funcionalidades para determinar el número mayor dentro de un array.
 * </p>
 * 
 * @author SanchezSuanezEsther
 * @version 1.0
 */
public class Mayor {

    /**
     * Devuelve el número entero mayor de un array de enteros.
     * <p>
     * Recorre el array y compara cada elemento para encontrar el valor máximo.
     * </p>
     * 
     * @param a array de enteros no vacío
     * @return el entero más grande dentro del array
     * @throws IllegalArgumentException si el array es nulo o está vacío
     */
    public static int elEnteroMayor(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío");
        }

        // Inicializar max con el primer elemento del array
        int max = a[0];

        // Recorrer el resto de los elementos del array
        for (int indice = 1; indice < a.length; indice++) {
            if (a[indice] > max) {
                max = a[indice];
            }
        }

        return max;
    }
}

