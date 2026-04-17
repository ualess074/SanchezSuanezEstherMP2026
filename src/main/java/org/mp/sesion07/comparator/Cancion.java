package org.mp.sesion07.comparator;

import java.util.Objects;

public class Cancion implements Comparable<Cancion> {

    private String artista;
    private String titulo;
    private int duracion;

    public Cancion(String artista, String titulo, int duracion) {
        this.artista = artista;
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public int compareTo(Cancion o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cancion)) return false;

        Cancion c = (Cancion) obj;
        return duracion == c.duracion &&
               artista.equals(c.artista) &&
               titulo.equals(c.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artista, titulo, duracion);
    }
}