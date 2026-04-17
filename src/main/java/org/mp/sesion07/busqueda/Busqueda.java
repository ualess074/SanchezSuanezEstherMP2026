package org.mp.sesion07.busqueda;

import java.util.Arrays;
import java.util.Random;

public class Busqueda<T extends Comparable<T>> {

    private T[] datos;
    private int numElementos;
    private T numBuscado;

    @SuppressWarnings("unchecked")
    public Busqueda(int numElementos) {
        this.numElementos = numElementos;
        this.datos = (T[]) new Comparable[numElementos];
        generarDatosAleatorios(numElementos);
        this.numBuscado = datos[new Random().nextInt(numElementos)];
    }

    private void generarDatosAleatorios(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            datos[i] = (T) Integer.valueOf(rand.nextInt(100));
        }
        Arrays.sort(datos);
    }

    public int getNumElementos() {
        return numElementos;
    }

    public T[] getDatos() {
        return datos;
    }

    public void setDatos(T[] datosModelo) {
        this.datos = datosModelo;
    }

    public T getNumBuscado() {
        return numBuscado;
    }

    public void setNumBuscado(T buscar) {
        this.numBuscado = buscar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Problema búsqueda con ").append(numElementos).append(" elementos\n");
        sb.append("Elemento buscado: ").append(numBuscado).append("\n");
        sb.append("[");
        for (int i = 0; i < datos.length; i++) {
            sb.append(datos[i]);
            if (i < datos.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
