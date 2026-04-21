package org.mp.sesion01.listareproduccion;

import java.util.Objects;

public class Cancion implements Comparable<Cancion> {

    private String titulo;
    private String artista;
    private int duracion;
    private String genero;

    public Cancion(String titulo, String artista, int duracion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }

    // GETTERS (NECESARIOS PARA TESTS)
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Cancion [titulo=" + titulo +
                ", artista=" + artista +
                ", duracion=" + duracion + "s" +
                ", genero=" + genero + "]";
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cancion)) return false;

        Cancion otra = (Cancion) o;

        return duracion == otra.duracion &&
               Objects.equals(titulo, otra.titulo) &&
               Objects.equals(artista, otra.artista) &&
               Objects.equals(genero, otra.genero);
    }

    @Override
    public int compareTo(Cancion otra) {
        if (this.duracion != otra.duracion) {
            return this.duracion - otra.duracion;
        }
        return this.titulo.compareTo(otra.titulo);
    }
}
