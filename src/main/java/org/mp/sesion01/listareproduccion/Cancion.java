package org.mp.sesion01.listareproduccion;

public class Cancion implements Comparable<Cancion> {

    private String titulo;
    private String artista;
    private int duracion;
    private String genero;

    // Constructor
    public Cancion(String titulo, String artista, int duracion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cancion [titulo=" + titulo +
                ", artista=" + artista +
                ", duracion=" + duracion + "s" +
                ", genero=" + genero + "]";
    }

    // Método equals
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Cancion)) {
            return false;
        }

        Cancion otra = (Cancion) o;

        return titulo.equals(otra.titulo) &&
               artista.equals(otra.artista) &&
               duracion == otra.duracion &&
               genero.equals(otra.genero);
    }

    // Método compareTo
    @Override
    public int compareTo(Cancion otra) {

        // Primero ordenar por duración
        if (this.duracion != otra.duracion) {
            return this.duracion - otra.duracion;
        }

        // Si duran lo mismo, ordenar por título
        return this.titulo.compareTo(otra.titulo);
    }
}
