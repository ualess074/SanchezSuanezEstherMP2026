package org.mp.sesion02;

/**
 * Representa una canción de un álbum.
 */
public class Cancion {

    private String titulo;
    private int duracion;

    /**
     * Constructor de la canción.
     * @param titulo Título de la canción
     * @param duracion Duración en segundos
     */
    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Devuelve una representación en texto de la canción.
     */
    @Override
    public String toString() {
        return titulo + " (" + duracion + "s)";
    }
}
