package org.mp.sesion07.comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

public class CatalogoAlbumesTest {

    private CatalogoAlbumes catalogo;

    @BeforeEach
    public void setUp() {
        catalogo = new CatalogoAlbumes();
        catalogo.add(new Album("Michael Jackson", "Thriller", 1982, 70000000L));
        catalogo.add(new Album("Pink Floyd", "The Dark Side of the Moon", 1973, 45000000L));
        catalogo.add(new Album("AC/DC", "Back in Black", 1980, 50000000L));
        catalogo.add(new Album("Meat Loaf", "Bat Out of Hell", 1977, 43000000L));
        catalogo.add(new Album("Eagles", "Their Greatest Hits", 1976, 42000000L));
    }

    @Test
    public void testOrdenarCatalogoNatural() {
        List<Album> lista = catalogo.getAlbumes();
        Collections.sort(lista); // Por año

        for (int i = 0; i < lista.size() - 1; i++) {
            assertTrue(lista.get(i).getAnyo() <= lista.get(i+1).getAnyo());
        }
    }

    @Test
    public void testOrdenarCatalogoVentasComparator() {
        List<Album> lista = catalogo.getAlbumes();
        lista.sort(new VentasComparator()); // Por ventas ascendente

        for (int i = 0; i < lista.size() - 1; i++) {
            assertTrue(lista.get(i).getVentas() <= lista.get(i+1).getVentas());
        }
    }

    @Test
    public void testOrdenarCatalogoArtistaTituloComparator() {
        List<Album> lista = catalogo.getAlbumes();
        lista.sort(new ArtistaTituloComparator());

        for (int i = 0; i < lista.size() - 1; i++) {
            Album a1 = lista.get(i);
            Album a2 = lista.get(i+1);
            if (a1.getArtista().equals(a2.getArtista())) {
                assertTrue(a1.getNombre().compareTo(a2.getNombre()) <= 0);
            } else {
                assertTrue(a1.getArtista().compareTo(a2.getArtista()) < 0);
            }
        }
    }
}
