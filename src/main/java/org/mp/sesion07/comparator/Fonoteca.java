package org.mp.sesion07.comparator;

public class Fonoteca {

    private String nombre;
    private Cancion[] canciones;

    public Fonoteca(String nombre, Cancion[] canciones) {
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public Cancion[] getCanciones() {
        return canciones;
    }
}
