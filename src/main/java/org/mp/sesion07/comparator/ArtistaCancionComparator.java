package org.mp.sesion07.comparator;

import java.util.Comparator;

public class ArtistaCancionComparator implements Comparator<Cancion> {

    @Override
    public int compare(Cancion c1, Cancion c2) {
        int cmp = c1.getArtista().compareTo(c2.getArtista());
        if (cmp == 0) {
            return c1.getTitulo().compareTo(c2.getTitulo());
        }
        return cmp;
    }
}
