package org.mp.sesion02;

/**
 * Clase que parsea datos de álbumes desde String.
 */
public class AlbumParser {

    public static Album parse(String datosAlbum) throws MiParseadoException {

        String[] partes = datosAlbum.split(";");

        if (!partes[0].equals("ALBUM")) {
            throw new MiParseadoException("Formato de álbum inválido");
        }

        String titulo = partes[1];
        String artista = partes[2];

        int año;
        try {
            año = Integer.parseInt(partes[3]);
        } catch (NumberFormatException e) {
            throw new MiParseadoException("Año del álbum inválido: " + partes[3]);
        }

        Album album = new Album(titulo, artista, año, 20);

        for (int i = 4; i < partes.length; i += 3) {

            if (!partes[i].equals("CANCION")) {
                throw new MiParseadoException("Formato de canción inválido en el álbum: ");
            }

            String tituloCancion = partes[i + 1];

            int duracion;
            try {
                duracion = Integer.parseInt(partes[i + 2]);
            } catch (NumberFormatException e) {
                throw new MiParseadoException("Duración de la canción inválida: " + partes[i + 2]);
            }

            album.agregarCancion(new Cancion(tituloCancion, duracion));
        }

        return album;
    }
}