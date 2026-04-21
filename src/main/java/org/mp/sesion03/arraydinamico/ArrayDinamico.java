package org.mp.sesion03.arraydinamico;

public class ArrayDinamico<T> {

    private T[] datos;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public ArrayDinamico() {
        datos = (T[]) new Object[0]; 
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
            throw new ArrayIndexOutOfBoundsException();
        }
        return datos[indice];
    }

    public void establecer(int indice, T elemento) {
        if (indice < 0 || indice >= tamaño) {
            throw new ArrayIndexOutOfBoundsException();
        }
        datos[indice] = elemento;
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = indice; i < tamaño - 1; i++) {
            datos[i] = datos[i + 1];
        }

        tamaño--;
        datos[tamaño] = null; 
    }

    public int capacidad() {
        return tamaño; 
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        int nuevaCapacidad = (datos.length == 0) ? 1 : datos.length * 2;
        T[] nuevo = (T[]) new Object[nuevaCapacidad];

        for (int i = 0; i < tamaño; i++) {
            nuevo[i] = datos[i];
        }

        datos = nuevo;
    }
}
