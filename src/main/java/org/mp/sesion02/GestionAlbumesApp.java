package org.mp.sesion02;

/**
 * Aplicación principal de gestión de álbumes.
 */
public class GestionAlbumesApp {

    public static void runApp(String[] datos) {

        System.out.println("--- Álbumes cargados ---");

        for (int i = 0; i < datos.length; i++) {
            try {
                Album album = AlbumParser.parse(datos[i]);
                System.out.println(album);
            } catch (MiParseadoException e) {
                System.err.println("Error procesando línea " + (i + 1) + ": " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        runApp(FuenteDeDatos.DATOS_ALBUMES);
    }
}
