package org.mp.sesion03.arraydinamico;

/**
 * Implementación genérica de un array dinámico
 */
public class ArrayDinamico<T> {

    private T[] datos;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public ArrayDinamico() {
        datos = (T[]) new Object[10];
        tamaño = 0;
    }

    public void agregar(T elemento) {

        if (tamaño == datos.length) {
            redimensionar();
        }

        datos[tamaño] = elemento;
        tamaño++;
    }

    public T obtener(int indice) {

        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException();
        }

        return datos[indice];
    }

    public void establecer(int indice, T elemento) {

        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException();
        }

        datos[indice] = elemento;
    }

    public int tamaño() {
        return tamaño;
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {

        T[] nuevo = (T[]) new Object[datos.length * 2];

        for (int i = 0; i < datos.length; i++) {
            nuevo[i] = datos[i];
        }

        datos = nuevo;
    }
}
