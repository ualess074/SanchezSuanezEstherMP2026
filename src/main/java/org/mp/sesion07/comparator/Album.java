package org.mp.sesion07.comparator;

public class Album implements Comparable<Album> {

    private String artista;
    private String nombre;
    private int anyo;
    private long ventas;

    public Album(String artista, String nombre, int anyo, long ventas) {
        this.artista = artista;
        this.nombre = nombre;
        this.anyo = anyo;
        this.ventas = ventas;
    }

    public String getArtista() { return artista; }
    public String getNombre() { return nombre; }
    public int getAnyo() { return anyo; }
    public long getVentas() { return ventas; }

    @Override
    public int compareTo(Album o) {
        return Integer.compare(this.anyo, o.anyo);
    }
}
