package org.mp.sesion07.busqueda;

import java.util.Arrays;

public class SolucionesBusqueda {

    public static <T extends Comparable<T>> int busquedaLineal(Busqueda<T> b)
            throws ElementoNoEncontradoException {

        T[] datos = b.getDatos();
        T objetivo = b.getNumBuscado();

        for (int i = 0; i < datos.length; i++) {
            if (datos[i].compareTo(objetivo) == 0) {
                return i;
            }
        }
        throw new ElementoNoEncontradoException("No encontrado");
    }

    public static <T extends Comparable<T>> int busquedaBinariaIter(Busqueda<T> b)
            throws ElementoNoEncontradoException {

        T[] datos = b.getDatos();
        T objetivo = b.getNumBuscado();

        int izq = 0, der = datos.length - 1;

        while (izq <= der) {
            int mid = (izq + der) / 2;
            int cmp = datos[mid].compareTo(objetivo);

            if (cmp == 0) return mid;
            if (cmp < 0) izq = mid + 1;
            else der = mid - 1;
        }

        throw new ElementoNoEncontradoException("No encontrado");
    }

    public static <T extends Comparable<T>> int busquedaBinariaRec(Busqueda<T> b)
            throws ElementoNoEncontradoException {
        return binariaRec(b.getDatos(), b.getNumBuscado(), 0, b.getDatos().length - 1);
    }

    private static <T extends Comparable<T>> int binariaRec(T[] datos, T objetivo, int izq, int der)
            throws ElementoNoEncontradoException {

        if (izq > der) throw new ElementoNoEncontradoException("No encontrado");

        int mid = (izq + der) / 2;
        int cmp = datos[mid].compareTo(objetivo);

        if (cmp == 0) return mid;
        if (cmp < 0) return binariaRec(datos, objetivo, mid + 1, der);
        else return binariaRec(datos, objetivo, izq, mid - 1);
    }

    public static <T extends Comparable<T>> int busquedaArraysBinarySearch(Busqueda<T> b) {
        return Arrays.binarySearch(b.getDatos(), b.getNumBuscado());
    }
}
