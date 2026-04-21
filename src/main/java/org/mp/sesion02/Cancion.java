package org.mp.sesion02;

/**
 * Representa una canción de un álbum.
 */
public class Cancion {

    private String titulo;
    private int duracion;

    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return titulo + " (" + duracion + "s)";
    }
}
