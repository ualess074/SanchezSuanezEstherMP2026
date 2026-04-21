package org.mp.sesion03.arraydinamico;

public class ArrayDinamicoObjects {

    private ArrayDinamico<Object> array;

    public ArrayDinamicoObjects() {
        array = new ArrayDinamico<>();
    }

    public void agregar(Object elemento) {
        array.agregar(elemento);
    }

    public Object obtener(int indice) {
        return array.obtener(indice);
    }

    public void establecer(int indice, Object elemento) {
        array.establecer(indice, elemento);
    }

    public void eliminar(int indice) {
        array.eliminar(indice);
    }

    public int capacidad() {
        return array.capacidad();
    }
}
