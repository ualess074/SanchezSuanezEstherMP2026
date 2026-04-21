package org.mp.sesion03.arraydinamico;

public class ArrayDinamicoEnteros {

    private ArrayDinamico<Integer> array;

    public ArrayDinamicoEnteros() {
        array = new ArrayDinamico<>();
    }

    public void agregar(int elemento) {
        array.agregar(elemento);
    }

    public int obtener(int indice) {
        return array.obtener(indice);
    }

    public void establecer(int indice, int elemento) {
        array.establecer(indice, elemento);
    }

    public void eliminar(int indice) {
        array.eliminar(indice);
    }

    public int capacidad() {
        return array.capacidad();
    }
}
