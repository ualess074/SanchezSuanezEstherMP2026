package org.mp.sesion02;

/**
 * Representa un álbum musical.
 */
public class Album implements Comparable<Album> {

    private String titulo;
    private String artista;
    private int año;
    private Cancion[] canciones;
    private int numCanciones;

    public Album(String titulo, String artista, int año, int maxCanciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new Cancion[maxCanciones];
        this.numCanciones = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getAño() {
        return año;
    }

    public void agregarCancion(Cancion c) {
        if (numCanciones < canciones.length) {
            canciones[numCanciones++] = c;
        }
    }

    public void mostrarCanciones() {
        for (int i = 0; i < numCanciones; i++) {
            System.out.println((i + 1) + ") " + canciones[i]);
        }
    }

    @Override
    public int compareTo(Album o) {
        if (this.año != o.año) {
            return this.año - o.año;
        }
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album album = (Album) o;

        return año == album.año &&
                titulo.equals(album.titulo) &&
                artista.equals(album.artista);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ALBUM: ").append(titulo).append("\n");
        sb.append("ARTISTA: ").append(artista)
          .append("\t\tAÑO: ").append(año).append("\n");

        for (int i = 0; i < numCanciones; i++) {
            sb.append(" ").append(i + 1)
              .append(") ")
              .append(canciones[i])
              .append("\n");
        }

        return sb.toString();
    }
}
