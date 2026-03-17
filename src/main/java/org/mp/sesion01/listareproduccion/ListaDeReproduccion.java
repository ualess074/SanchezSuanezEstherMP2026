package org.mp.sesion01.listareproduccion;

public class ListaDeReproduccion {

    private Cancion[] canciones;
    private int numCanciones;

    public ListaDeReproduccion(String nombre, int capacidadMaxima) {
        this.canciones = new Cancion[capacidadMaxima];
        this.numCanciones = 0;
    }

    public void agregarCancion(Cancion c) {
        if (numCanciones < canciones.length) {
            canciones[numCanciones] = c;
            numCanciones++;
        } else {
            System.out.println("No hay espacio para más canciones.");
        }
    }

    public void mostrarCanciones() {
        for (int i = 0; i < numCanciones; i++) {
            System.out.println(canciones[i]);
        }
    }

    // Bubble Sort
    public void ordenarCanciones() {

        for (int i = 0; i < numCanciones - 1; i++) {
            for (int j = 0; j < numCanciones - 1 - i; j++) {

                if (canciones[j].compareTo(canciones[j + 1]) > 0) {

                    Cancion temp = canciones[j];
                    canciones[j] = canciones[j + 1];
                    canciones[j + 1] = temp;
                }
            }
        }
    }
}
