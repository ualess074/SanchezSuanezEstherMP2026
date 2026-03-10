package org.mp.sesion02;

import java.util.Objects;

/**
 * Representa un álbum musical.
 */
public class Album implements Comparable<Album> {

    private String titulo;
    private String artista;
    private int año;
    private Cancion[] canciones;
    private int numCanciones;

    /**
     * Constructor del álbum.
     */
    public Album(String titulo, String artista, int año, int maxCanciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new Cancion[maxCanciones];
        this.numCanciones = 0;
    }

    /**
     * Añade una canción al álbum.
     */
    public void agregarCancion(Cancion c) {
        if (numCanciones < canciones.length) {
            canciones[numCanciones++] = c;
        }
    }

    /**
     * Muestra las canciones del álbum.
     */
    public void mostrarCanciones() {
        for (int i = 0; i < numCanciones; i++) {
            System.out.println((i + 1) + ") " + canciones[i]);
        }
    }

    /**
     * Compara álbumes por año y título.
     */
    @Override
    public int compareTo(Album o) {

        if (this.año != o.año) {
            return this.año - o.año;
        }

        return this.titulo.compareTo(o.titulo);
    }

    /**
     * Comprueba si dos álbumes son iguales.
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        return año == album.año &&
                titulo.equals(album.titulo) &&
                artista.equals(album.artista);
    }

    /**
     * Representación en texto del álbum.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("ALBUM: ").append(titulo).append("\n");
        sb.append("ARTISTA: ").append(artista)
                .append("    AÑO: ").append(año).append("\n");

        for (int i = 0; i < numCanciones; i++) {
            sb.append(" ").append(i + 1)
                    .append(") ")
                    .append(canciones[i])
                    .append("\n");
        }

        return sb.toString();
    }
}
