package org.mp.sesion02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para AlbumParser.
 */
class AlbumParserTest {

    /**
     * Prueba el método parse con una cadena de álbum válida con canciones.
     */
    @Test
    void testParseValidAlbumWithSongs() throws MiParseadoException {
        String albumData = "ALBUM;El Mal Querer;Rosalía;2018;CANCION;Malamente;150;CANCION;Pienso en tu mirá;193";
        Album album = AlbumParser.parse(albumData);

        assertNotNull(album);
        assertEquals("El Mal Querer", album.getTitulo()); // Acceso con getter
        assertEquals("Rosalía", album.getArtista());
        assertEquals(2018, album.getAño());

        String expectedToString = "ALBUM: El Mal Querer\n" +
                                  "ARTISTA: Rosalía		AÑO: 2018\n" +
                                  " 1) Malamente (150s)\n" +
                                  " 2) Pienso en tu mirá (193s)\n";
        assertEquals(expectedToString, album.toString());
    }

    /**
     * Prueba el método parse con una cadena de álbum válida sin canciones.
     */
    @Test
    void testParseValidAlbumNoSongs() throws MiParseadoException {
        String albumData = "ALBUM;Vacío;Artista Solitario;2023";
        Album album = AlbumParser.parse(albumData);

        assertNotNull(album);
        assertEquals("Vacío", album.getTitulo());
        assertEquals("Artista Solitario", album.getArtista());
        assertEquals(2023, album.getAño());

        String expectedToString = "ALBUM: Vacío\n" +
                                  "ARTISTA: Artista Solitario		AÑO: 2023\n";
        assertEquals(expectedToString, album.toString());
    }

    /**
     * Prueba el método parse con un formato de álbum inválido (no empieza con "ALBUM").
     */
    @Test
    void testParseInvalidAlbumFormat() {
        String albumData = "INVALID;El Mal Querer;Rosalía;2018";
        try {
            AlbumParser.parse(albumData);
            fail("Debería haber lanzado MiParseadoException");
        } catch (MiParseadoException thrown) {
            assertEquals("Formato de álbum inválido", thrown.getMessage());
        }
    }

    /**
     * Prueba el método parse con un formato de año inválido.
     */
    @Test
    void testParseInvalidYearFormat() {
        String albumData = "ALBUM;El Mal Querer;Rosalía;AAAA";
        try {
            AlbumParser.parse(albumData);
            fail("Debería haber lanzado MiParseadoException");
        } catch (MiParseadoException thrown) {
            assertTrue(thrown.getMessage().contains("Año del álbum inválido: AAAA"));
        }
    }

    /**
     * Prueba el método parse con un formato de canción inválido (no empieza con "CANCION").
     */
    @Test
    void testParseInvalidSongFormat() {
        String albumData = "ALBUM;El Mal Querer;Rosalía;2018;WRONG;Malamente;150";
        try {
            AlbumParser.parse(albumData);
            fail("Debería haber lanzado MiParseadoException");
        } catch (MiParseadoException thrown) {
            assertEquals("Formato de canción inválido en el álbum: ", thrown.getMessage());
        }
    }

    /**
     * Prueba el método parse con un formato de duración de canción inválido.
     */
    @Test
    void testParseInvalidSongDurationFormat() {
        String albumData = "ALBUM;El Mal Querer;Rosalía;2018;CANCION;Malamente;ABC";
        try {
            AlbumParser.parse(albumData);
            fail("Debería haber lanzado MiParseadoException");
        } catch (MiParseadoException thrown) {
            assertTrue(thrown.getMessage().contains("Duración de la canción inválida: ABC"));
        }
    }
}
