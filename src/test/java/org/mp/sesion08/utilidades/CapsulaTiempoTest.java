package org.mp.sesion08.utilidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mp.sesion07.comparator.Cancion;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CapsulaTiempoTest {

    @TempDir
    Path tempDir;

    private List<Cancion> playlistOriginal;

    @BeforeEach
    public void setUp() {
        playlistOriginal = new ArrayList<>();
        playlistOriginal.add(new Cancion("The Beatles", "Yesterday", 125));
        playlistOriginal.add(new Cancion("Queen", "Bohemian Rhapsody", 354));
        playlistOriginal.add(new Cancion("Pink Floyd", "Time", 421));
    }

    @Test
    public void testGuardarYCargarPlaylist() throws IOException {
        File archivo = tempDir.resolve("playlist.txt").toFile();
        String ruta = archivo.getAbsolutePath();

        // Guardar
        CapsulaTiempo.guardarPlaylist(playlistOriginal, ruta);
        assertTrue(archivo.exists());

        // Cargar
        List<Cancion> playlistCargada = CapsulaTiempo.cargarPlaylist(ruta);

        assertEquals(playlistOriginal.size(), playlistCargada.size());
        for (int i = 0; i < playlistOriginal.size(); i++) {
            assertEquals(playlistOriginal.get(i).getArtista(), playlistCargada.get(i).getArtista());
            assertEquals(playlistOriginal.get(i).getTitulo(), playlistCargada.get(i).getTitulo());
            assertEquals(playlistOriginal.get(i).getDuracion(), playlistCargada.get(i).getDuracion());
        }
    }
}
