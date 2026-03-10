package org.mp.sesion02;

/**
 * Clase que parsea datos de álbumes desde String.
 */
public class AlbumParser {

    public static Album parse(String datosAlbum) throws MiParseadoException {

        try {

            String[] partes = datosAlbum.split(";");

            if (!partes[0].equals("ALBUM")) {
                throw new MiParseadoException("Formato incorrecto");
            }

            String titulo = partes[1];
            String artista = partes[2];
            int año = Integer.parseInt(partes[3]);

            Album album = new Album(titulo, artista, año, 20);

            for (int i = 4; i < partes.length; i += 3) {

                if (!partes[i].equals("CANCION")) {
                    throw new MiParseadoException("Formato de canción incorrecto");
                }

                String tituloCancion = partes[i + 1];
                int duracion = Integer.parseInt(partes[i + 2]);

                album.agregarCancion(new Cancion(tituloCancion, duracion));
            }

            return album;

        } catch (Exception e) {

            throw new MiParseadoException("Error al parsear el álbum", e);
        }
    }
}