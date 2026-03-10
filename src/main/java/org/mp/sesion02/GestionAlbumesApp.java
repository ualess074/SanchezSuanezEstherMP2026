package org.mp.sesion02;

/**
 * Aplicación principal de gestión de álbumes.
 */
public class GestionAlbumesApp {

    public static void main(String[] args) {

        Album[] albumes = new Album[FuenteDeDatos.DATOS_ALBUMES.length];

        for (int i = 0; i < FuenteDeDatos.DATOS_ALBUMES.length; i++) {

            try {

                albumes[i] = AlbumParser.parse(FuenteDeDatos.DATOS_ALBUMES[i]);

                System.out.println(albumes[i]);

            } catch (MiParseadoException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
